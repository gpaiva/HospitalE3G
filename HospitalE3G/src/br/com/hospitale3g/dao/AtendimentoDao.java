package br.com.hospitale3g.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import br.com.hospitale3g.controller.Lib;
import static br.com.hospitale3g.dao.Dao.url;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.model.Paciente;
import br.com.hospitale3g.model.Enfermeiro;
import br.com.hospitale3g.model.Atendimento;
import br.com.hospitale3g.view.DExcecao;

public class AtendimentoDao extends Dao {

    static final String atencodigo = "atencodigo";
    static final String crm = "crm";
    static final String id = "id";
    static final String coren = "coren";
    static final String atendatahora = "atendatahora";
    static final String atendatahorafinalizado = "atendatahorafinalizado";
    static final String atensituacao = "atensituacao";
    static final String atenobservacao = "atenobservacao";

    public List<Atendimento> select() {
        String sqlQuery = "SELECT * "
                + " FROM ATENDIMENTO ";

        this.connect(Dao.url);//conecta com o banco de dados
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();//cria um list de atendimento
        ResultSet resultSet;//cria um novo resultSet
        try {
            resultSet = this.getStatement().executeQuery(sqlQuery);//resultSet recebe os dados retornado da query
            while (resultSet.next()) {//caso ainda exista proximo no resultset
                //passa as informações para as variaveis
                int situacao = resultSet.getInt(AtendimentoDao.atensituacao);
                String dataFinalizado = "";
                String horaFinalizado = "";
                if (situacao == 2) {
                    dataFinalizado = new SimpleDateFormat("dd/MM/yyyy").format(resultSet.getDate(AtendimentoDao.atendatahorafinalizado));
                    horaFinalizado = resultSet.getTime(AtendimentoDao.atendatahorafinalizado).toString();
                }

                //instancia um novo atendimento com os valores resultados do resultSet
                Atendimento atendimento = new Atendimento(
                        resultSet.getInt(AtendimentoDao.atencodigo),
                        resultSet.getString(AtendimentoDao.crm),
                        resultSet.getInt(AtendimentoDao.id),
                        resultSet.getString(AtendimentoDao.coren),
                        new SimpleDateFormat("dd/MM/yyyy").format(resultSet.getDate(AtendimentoDao.atendatahora)),
                        resultSet.getTime(AtendimentoDao.atendatahora).toString(),
                        dataFinalizado,
                        horaFinalizado,
                        situacao,
                        resultSet.getString(AtendimentoDao.atenobservacao));
                //adiciona o atendimento criado para a list
                atendimentos.add(atendimento);
            }
            //retorna a lista
            return (atendimentos);
        } catch (SQLException e) {//caso ocorra alguma exceção é mostrado a tela de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);//retorna null pois ocorreu erro ao criar a lista
        } finally {
            this.close();//fecha a conexão com o banco de dados
        }
    }

    //função para inserir atendimento no banco de dados
    public void insert(Atendimento atendimento) {
        String sqlQuery = "INSERT INTO ATENDIMENTO(ATENCODIGO, CRM, ID, "
                + "ATENDATAHORA, ATENDATAHORAFINALIZADO, ATENSITUACAO, ATENOBSERVACAO)"
                + "VALUES(" + atendimento.getAtenCodigo() + ", "
                + Lib.quotedStr(atendimento.getCrm()) + ", "
                + atendimento.getId() + ", "
                + "CURRENT_TIMESTAMP(), NULL,"
                + atendimento.getAtenSituacao() + ", "
                + Lib.quotedStr(atendimento.getAtenObservacao()) + ");";

        this.connect(Dao.url);//conecta com o banco de dados
        try {
            this.getStatement().executeUpdate(sqlQuery);//executa a query
        } catch (SQLException e) {//caso houver alguma exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);//é mostrado a tela de exceção junto com a mensagem
        } finally {
            this.close();//fecha a conexão
        }
    }

    public void update(Atendimento atendimento) {
        String observacao = Lib.iif(atendimento.getAtenObservacao().isEmpty(), " ", atendimento.getAtenObservacao());

        String sqlQuery = "UPDATE ATENDIMENTO "
                + "SET ATENDATAHORA = ATENDATAHORA, "
                + " ATENCODIGO = " + atendimento.getAtenCodigo() + ", "
                + " CRM = " + Lib.quotedStr(atendimento.getCrm()) + ", "
                + " ID = " + atendimento.getId() + ", "
                + " ATENSITUACAO = " + atendimento.getAtenSituacao() + ", "
                + " ATENOBSERVACAO = " + Lib.quotedStr(observacao) + " "
                + " WHERE ATENCODIGO = " + atendimento.getAtenCodigo() + ";";
        String sqlQueryCoren = "";
        //caso tenha sido informado um coren, é passado um script para atualizar o coren
        if (atendimento.getCoren() != null) {
            sqlQueryCoren = "UPDATE ATENDIMENTO "
                    + " SET ATENDATAHORA = ATENDATAHORA,"
                    + " COREN = " + Lib.quotedStr(atendimento.getCoren())
                    + " WHERE ATENCODIGO = " + atendimento.getAtenCodigo() + ";";
        }
        String sqlQueryFinalizado = "";
        //caso a situação for finalizado, é atualizado a data de finalização do atendimento
        if (atendimento.getAtenSituacao() == 2) {
            sqlQueryFinalizado = "UPDATE ATENDIMENTO "
                    + " SET ATENDATAHORA = ATENDATAHORA, "
                    + " ATENDATAHORAFINALIZADO = CURRENT_TIMESTAMP() "
                    + " WHERE ATENCODIGO = " + atendimento.getAtenCodigo() + ";";
        }
        this.connect(Dao.url);//conecta com o bd
        try {
            this.getStatement().executeUpdate(sqlQuery);//executa a query principal
            if (!sqlQueryCoren.isEmpty()) {//se a query do Coren nao está vazia
                this.getStatement().executeUpdate(sqlQueryCoren);//executa a query do coren
            }
            if (!sqlQueryFinalizado.isEmpty()) {//se a query de situação finalizado nao estiver vazia
                this.getStatement().executeUpdate(sqlQueryFinalizado);//executa a query da situação
            }
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
    }

    //função para deletar um atendimento
    public void delete(int atenCodigo) {
        String sqlQuery = "UPDATE ATENDIMENTO "
                + " SET ATENSITUACAO = 1 "
                + "WHERE ATENCODIGO = " + atenCodigo;

        this.connect(Dao.url);//conecta com o bd
        try {
            this.getStatement().executeUpdate(sqlQuery);//executa o script de exclusão
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();//fecha o banco de dados
        }
    }

    //retorna uma instancia de Atendimento, dependendo do código passado como parametro
    public Atendimento getAtendimento(int atenCodigo) {
        String sqlQuery = "SELECT * "
                + " FROM ATENDIMENTO "
                + " WHERE ATENCODIGO = " + atenCodigo;

        this.connect(Dao.url);//conecta com o bd
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();//instancia uma lista de atendimento
        ResultSet resultSet;//cria um resultSet
        try {
            //resultSet recebe os dados retornados da query
            resultSet = this.getStatement().executeQuery(sqlQuery);
            //se não estiver nulo e existir registro
            if ((resultSet != null) && (resultSet.next())) {
                //é instanciado um novo Atendimento de acordo com os valores retornados
                //do resultSet
                Atendimento atendimento = new Atendimento(
                        resultSet.getInt(AtendimentoDao.atencodigo),
                        resultSet.getString(AtendimentoDao.crm),
                        resultSet.getInt(AtendimentoDao.id),
                        resultSet.getString(AtendimentoDao.coren),
                        resultSet.getDate(AtendimentoDao.atendatahora).toString(),
                        resultSet.getTime(AtendimentoDao.atendatahora).toString(),
                        resultSet.getDate(AtendimentoDao.atendatahorafinalizado).toString(),
                        resultSet.getTime(AtendimentoDao.atendatahorafinalizado).toString(),
                        resultSet.getInt(AtendimentoDao.atensituacao),
                        resultSet.getString(AtendimentoDao.atenobservacao));
                //retorna o atendimento
                return (atendimento);
            }
            //se chegar aqui, não existe nenhum atendimento, logo, retorna null
            return (null);
        } catch (SQLException e) {//tratamento de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();//fecha o bd
        }
    }

    //função para saber se existe um atendimento com aquele código
    public boolean findAtendimento(int atenCodigo) {
        //conecta com o bd
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM ATENDIMENTO "
                    + " WHERE ATENCODIGO LIKE " + atenCodigo;
            //resultSet recebe os dados da query
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            //retorna se existe um valor da query
            return (resultSet.first());
        } catch (SQLException e) {//tratamento de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            //fecha o bd
            this.close();
        }
        //se chegar aqui, é porque não foi encontrado nenhum atendimento
        return (false);
    }

    //função para obter o proximo código
    public int getNextAtenCodigo() {
        int aux = -1;
        String sqlQuery = "SELECT COALESCE(MAX(ATENCODIGO), 0) + 1 AS ATENCODIGO "
                + " FROM ATENDIMENTO ";

        //conecta com o banco de dados
        this.connect(Dao.url);
        try {
            //resultSet recebe os dados da query
            ResultSet rs = this.getStatement().executeQuery(sqlQuery);
            while (rs.next()) {
                //variavel auxiliar para receber o maior código + 1
                aux = rs.getInt("ATENCODIGO");
            }
        } catch (SQLException e) {//tratamento de exceções
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();//fecha a conexao
        }
        //retorna o valor maximo + 1 do código
        return (aux);
    }

    //função para retornar as colunas do grid
    public String[] getColumns() {
        String[] aux = {"Código", "Médico", "Código Médico", "Paciente", "Código Paciente",
            "Situação", "Enfermeiro", "Código Enfermeiro", "Data", "Hora", "Data Finalização",
            "Hora Finalização", "Observação"};
        return (aux);
    }

    //função para retornar o modelo do grid
    public DefaultTableModel getTableModel() {
        //impedir que as celulas do grid seja alteradas
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };

        //adiciona as colunas no grid
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        for (int i = 0; i <= atendimentoDao.getColumns().length - 1; i++) {
            String[] aux = atendimentoDao.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);

        //adicionar os valores no grid, lembrando que as posições devem ser
        //as mesmas das colunas
        for (Atendimento atendimento : this.select()) {
            MedicoDao medicoDao = new MedicoDao();
            Medico medico = medicoDao.getMedico(atendimento.getCrm());
            PacienteDao pacienteDao = new PacienteDao();
            Paciente paciente = pacienteDao.getPacienteId(atendimento.getId());
            String enfermeiroNome = "";
            String enfermeiroCodPessoa = "";
            if (atendimento.getCoren() != null) {
                EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
                Enfermeiro enfermeiro = enfermeiroDao.getEnfermeiro(atendimento.getCoren());
                enfermeiroNome = enfermeiro.getNome();
                enfermeiroCodPessoa = Integer.toString(enfermeiro.getCodPessoa());
            }

            String situacao;
            switch (atendimento.getAtenSituacao()) {
                case 0:
                    situacao = "Aberto";
                    break;
                case 1:
                    situacao = "Cancelado";
                    break;
                case 2:
                    situacao = "Finalizado";
                    break;
                default:
                    situacao = "Desconhecido";
                    break;
            }

            model.addRow(new Object[]{atendimento.getAtenCodigo(),
                medico.getNome(),
                medico.getCodPessoa(),
                paciente.getNome(),
                paciente.getCodPessoa(),
                situacao,
                enfermeiroNome,
                enfermeiroCodPessoa,
                atendimento.getAtenData(),
                atendimento.getAtenHora(),
                atendimento.getAtenDataFinalizado(),
                atendimento.getAtenHoraFinalizado(),
                atendimento.getAtenObservacao()});
        }
        return (model);
    }

    //retorna o relatorio
    public JasperViewer getIReport() {
        String query = "SELECT A.*, "
                + "        CASE A.ATENSITUACAO "
                + "        WHEN 0 THEN ' ' "
                + "        WHEN 1 THEN ' ' "
                + "        ELSE A.ATENDATAHORAFINALIZADO "
                + "        END AS DATAHORAFINALIZADO, "
                + "        CASE A.ATENSITUACAO "
                + "        WHEN 0 THEN 'Aberto' "
                + "        WHEN 1 THEN 'Cancelado' "
                + "        WHEN 2 THEN 'Finalizado' "
                + "        ELSE 'Desconhecido' "
                + "        END AS SITUACAO, "
                + "       (SELECT PE.NOME "
                + "        FROM PESSOA PE "
                + "        WHERE PE.CODPESSOA = M.CODPESSOA) AS NOMEMEDICO, "
                + "       (SELECT CASE PE.NOME "
                + "               WHEN NULL THEN ' ' "
                + "               ELSE PE.NOME "
                + "               END "
                + "        FROM PESSOA PE "
                + "        WHERE PE.CODPESSOA = E.CODPESSOA) AS NOMEENFERMEIRO, "
                + "       (SELECT PE.NOME "
                + "        FROM PESSOA PE "
                + "        WHERE PE.CODPESSOA = P.CODPESSOA) AS NOMEPACIENTE "
                + "FROM ATENDIMENTO A "
                + "JOIN MEDICO M ON M.CRM = A.CRM "
                + "JOIN PACIENTE P ON P.ID = A.ID "
                + "LEFT JOIN ENFERMEIRO E ON E.COREN = A.COREN";

        this.connect(url);//conecta com o banco de dados
        try {
            this.getStatement().execute(query);//executa a query do relatorio
            //cria um resultSet para o relatorio
            JRResultSetDataSource relResult = new JRResultSetDataSource(this.getStatement().getResultSet());
            //é criado uma instancia do relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/Atendimento.jasper", new HashMap(), relResult);
            return (new JasperViewer(jpPrint, true));//retorna o relatorio
        } catch (SQLException | JRException ex) {//tratamento de exceção padrão
            DExcecao excecao = new DExcecao(null, true, ex.getMessage());
            excecao.setVisible(true);
        }
        //caso chegar aqui, ocorreu um erro ao criar o relatorio, logo é retornado null
        return (null);
    }
}
