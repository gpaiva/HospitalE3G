package br.com.hospitale3g.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import br.com.hospitale3g.controller.EnfermeiroController;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.MedicoController;
import br.com.hospitale3g.controller.PacienteController;
import br.com.hospitale3g.controller.SecretarioController;
import br.com.hospitale3g.model.Enfermeiro;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.model.Paciente;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Secretario;
import br.com.hospitale3g.view.DExcecao;

public class PessoaDao extends Dao {

    //constantes com os nomes de cada atributo no banco de dados
    static final String codPessoa = "codPessoa";
    static final String nome = "nome";
    static final String cpf = "cpf";
    static final String rg = "rg";
    static final String sexo = "sexo";
    static final String rua = "rua";
    static final String numero = "numero";
    static final String complemento = "complemento";
    static final String bairro = "bairro";
    static final String cidade = "cidade";
    static final String cep = "cep";

    //instancia um PessoaDao
    public PessoaDao() {
        super();
    }

    //função que retorna em uma lista, os dados que estão no banco de dados
    public List<Pessoa> select() {
        String sqlQuery = "SELECT * "
                + "FROM PESSOA";

        //conecta no banco de dados
        this.connect(Dao.url);
        //instancia uma lista de pessoas
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        ResultSet resultSet;
        try {
            //resultSet recebe os dados retornados da query
            resultSet = this.getStatement().executeQuery(sqlQuery);
            //caso ainda houver proximo no resultSet
            while (resultSet.next()) {
                //é criado uma nova instancia de pessoa de acordo com os dados
                //do resultSet
                Pessoa pessoa = new Pessoa(resultSet.getInt(codPessoa),
                        resultSet.getString(nome),
                        resultSet.getString(sexo).charAt(0),
                        resultSet.getString(cpf),
                        resultSet.getString(rg),
                        resultSet.getString(rua),
                        resultSet.getString(numero),
                        resultSet.getString(complemento),
                        resultSet.getString(bairro),
                        resultSet.getString(cidade),
                        resultSet.getString(cep));
                //adiciona a pessoa na lista de pessoas
                pessoas.add(pessoa);
            }
            //retorna a lista de pessoas
            return (pessoas);
        } catch (SQLException e) {//tratamento de exceções
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();//fecha o banco de dados
        }
    }

    //função que insere uma pessoa no banco de dados
    public void insert(Pessoa pessoa) {
        String sqlQuery = "INSERT INTO PESSOA(CODPESSOA, NOME, CPF, RG, SEXO, "
                + "RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, CEP) "
                + "VALUES(" + pessoa.getCodPessoa() + ", "
                + Lib.quotedStr(pessoa.getNome()) + ", "
                + Lib.quotedStr(pessoa.getCpf()) + ", "
                + Lib.quotedStr(pessoa.getRg()) + ", "
                + Lib.quotedStr(pessoa.getSexo()) + ", "
                + Lib.quotedStr(pessoa.getRua()) + ", "
                + Lib.quotedStr(pessoa.getNumero()) + ", "
                + Lib.quotedStr(pessoa.getComplemento()) + ", "
                + Lib.quotedStr(pessoa.getBairro()) + ", "
                + Lib.quotedStr(pessoa.getCidade()) + ", "
                + Lib.quotedStr(pessoa.getCep()) + ");";

        //conecta com o banco de dados
        this.connect(Dao.url);
        try {
            //executa a query
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {//tratamento de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();//fecha a conexão
        }
    }

    //função que atualiza a pessoa passada por parametro no banco de dados
    public void update(Pessoa pessoa) {
        String sqlQuery = "UPDATE PESSOA "
                + "SET CODPESSOA = " + pessoa.getCodPessoa() + ", "
                + " NOME = " + Lib.quotedStr(pessoa.getNome()) + ", "
                + " CPF = " + Lib.quotedStr(pessoa.getCpf()) + ", "
                + " RG = " + Lib.quotedStr(pessoa.getRg()) + ", "
                + " SEXO = " + Lib.quotedStr(pessoa.getSexo()) + ", "
                + " RUA = " + Lib.quotedStr(pessoa.getRua()) + ", "
                + " NUMERO = " + Lib.quotedStr(pessoa.getNumero()) + ", "
                + " COMPLEMENTO = " + Lib.quotedStr(pessoa.getComplemento()) + ", "
                + " BAIRRO = " + Lib.quotedStr(pessoa.getBairro()) + ", "
                + " CIDADE = " + Lib.quotedStr(pessoa.getCidade()) + ", "
                + " CEP = " + Lib.quotedStr(pessoa.getCep()) + " "
                + "WHERE CODPESSOA = " + pessoa.getCodPessoa();

        //conecta com o bd
        this.connect(Dao.url);
        try {
            //executa a query
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {//tratamento de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            //fecha a conexão
            this.close();
        }
    }

    //função que delete uma pessoa de acordo com o código passado por parametro
    public void delete(int codPessoa) {
        String sqlQuery = "DELETE FROM PESSOA "
                + " WHERE CODPESSOA = " + codPessoa;

        //conecta com o banco de dados
        this.connect(Dao.url);
        try {
            //executa a query
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {//tratamento de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            //fecha a conexão com o banco de dados
            this.close();
        }
    }

    //função que retorna o proximo código da pessoa
    public int getNextCodPessoa() {
        int aux = -1;
        String sqlQuery = "SELECT COALESCE(MAX(CODPESSOA), 0) + 1 AS CODPESSOA "
                + " FROM PESSOA ";

        //conecta com o bando de dados
        this.connect(Dao.url);
        try {
            //resultSet recebe os dados da query
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            while (resultSet.next()) {
                //aux recebe o valor retornado da query
                aux = resultSet.getInt(codPessoa);
            }
        } catch (SQLException e) {//tratamento de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            //fecha a conexão
            this.close();
        }
        //retorna o proximo valor do código
        return (aux);
    }

    //função que retorna uma Pessoa de acordo com o código passado como parametro
    public Pessoa getPessoa(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM PESSOA "
                + " WHERE CODPESSOA = " + codPessoa;

        //conecta com o banco de dados
        this.connect(Dao.url);
        //instancia uma lista de pessoa
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        //cria o resultSet
        ResultSet resultSet;
        try {
            //resultSet recebe os dados retornados da query
            resultSet = this.getStatement().executeQuery(sqlQuery);

            //verifica se não está nulo, e se existe proximo dentro do resultSet
            if ((resultSet != null) && (resultSet.next())) {
                //instancia uma pessoa de acordo com os dados do resultSet
                Pessoa pessoa = new Pessoa(resultSet.getInt(PessoaDao.codPessoa),
                        resultSet.getString(PessoaDao.nome),
                        resultSet.getString(PessoaDao.sexo).charAt(0),
                        resultSet.getString(PessoaDao.cpf),
                        resultSet.getString(PessoaDao.rg),
                        resultSet.getString(rua),
                        resultSet.getString(numero),
                        resultSet.getString(complemento),
                        resultSet.getString(bairro),
                        resultSet.getString(cidade),
                        resultSet.getString(cep));
                //retorna  pessoa instanciada
                return (pessoa);
            }
            return (null);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    //função que verifica se existe o cpf passado por parametro, dentro do bd
    public boolean existsPessoaCpf(String cpf) {
        //conecta com o bd
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM PESSOA "
                    + " WHERE CPF LIKE " + Lib.quotedStr(cpf) + ";";
            //resultSet recebe os dados da query
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            //retorna se existe um primeiro registro
            return (result.first());
        } catch (SQLException e) {//tratamento de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            //fecha a conexão
            this.close();
        }
        return (false);
    }

    //função que verifica se existe um rg dentro do bd
    public boolean existsPessoaRg(String rg) {
        //conecta com o bd
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM PESSOA "
                    + " WHERE RG LIKE " + Lib.quotedStr(rg) + ";";

            //resultSet que recebe os dados da query
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            //retorna se existe um primeiro registro no resultSet
            return (resultSet.first());
        } catch (SQLException e) {//tratamento de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            //fecha a conexão
            this.close();
        }
        return (false);
    }

    //função que retorna o tipo da pessoa
    public String getPessoa(Pessoa pessoa) {
        //se o código for 1, então é o administrador
        if (pessoa.getCodPessoa() == 1) {
            return ("Administrador");
        }
        
        //se existir algum registro dessa pessoa em outra tabela, significa
        //que ela é um registro dessa tabela
        Enfermeiro enfermeiro = EnfermeiroController.getEnfermeiro(pessoa.getCodPessoa());
        if (enfermeiro != null) {
            return ("Enfermeiro");
        }
        Medico medico = MedicoController.getMedico(pessoa.getCodPessoa());
        if (medico != null) {
            return ("Médico");
        }
        Paciente paciente = PacienteController.getPaciente(pessoa.getCodPessoa());
        if (paciente != null) {
            return ("Paciente");
        }
        Secretario secretario = SecretarioController.getSecretario(pessoa.getCodPessoa());
        if (secretario != null) {
            return ("Secretário");
        }
        return ("Desconhecido");
    }

    //função que verifica se a pessoa está vinculada a qualquer atendimento
    public boolean hasDependenceAtendimento(int codPessoa) {
        //conecta com o banco de dados
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT A.* "
                    + "FROM ATENDIMENTO A "
                    + "LEFT JOIN ENFERMEIRO E ON E.COREN = A.COREN "
                    + "LEFT JOIN MEDICO M ON M.CRM = A.CRM "
                    + "LEFT JOIN PACIENTE P ON P.ID = A.ID "
                    + "WHERE (E.CODPESSOA = " + codPessoa + ") OR  "
                    + "      (M.CODPESSOA = " + codPessoa + ") OR "
                    + "      (P.CODPESSOA = " + codPessoa + ");";
            
            //resultSet recebe os dados retornados da query
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            //retorna se existe algum dado da query
            return (resultSet.first());
        } catch (SQLException e) {//tratamento de exceções
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
        return (false);
    }

    //função que verifica se existe alguma depedencia com usuario, passando como
    //parametro o crm
    public boolean hasDependenceUsuario(String crm) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT U.* "
                    + " FROM USUARIO U "
                    + " WHERE U.CODPESSOA = (SELECT M.CODPESSOA"
                    + " FROM MEDICO M "
                    + " WHERE M.CRM LIKE " + Lib.quotedStr(crm) + ");";
            //retorna os valores da query
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            //retorna verdadeiro se existir algum valor nesse resultSet
            return (resultSet.first());
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
        return (false);
    }

    
    //função que verifica se existe alguma depedencia com usuario, passando como
    //parametro o codido da pessoa
    public boolean hasDependenceUsuario(int codPessoa) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT U.* "
                    + " FROM USUARIO U "
                    + " WHERE U.CODPESSOA = " + codPessoa + ";";
            
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
        return (false);
    }

    //função que retorna os nomes das colunas do grid
    public String[] getColumns() {
        String[] aux = {"Código", "Nome", "Sexo", "CPF", "RG",
            "Rua", "Número", "Complemento", "Bairro", "Cidade", "CEP"};
        return (aux);
    }
    
    //função que retorna o modelo do grid
    public DefaultTableModel getTableModel() {
        //passa a opção de alterar as celulas do grid para falso
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };

        //adiciona as colunas no grid
        for (int i = 0; i <= this.getColumns().length - 1; i++) {
            String[] aux = this.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        
        //adiciona os valores recebidos da função select no grid
        for (Pessoa pessoa : this.select()) {
            model.addRow(new Object[]{pessoa.getCodPessoa(),
                pessoa.getNome(),
                Lib.iif(pessoa.getSexo() == 'M', "Masculino", "Feminino"),
                pessoa.getCpf(),
                pessoa.getRg(),
                pessoa.getRua(),
                pessoa.getNumero(),
                pessoa.getComplemento(),
                pessoa.getBairro(),
                pessoa.getCidade(),
                pessoa.getCep()});
        }
        return (model);
    }

    //função que retorna o relatorio
    public JasperViewer getIReport() {
        //conecta com o bd
        this.connect(url);
        try {
            //salva a query
            this.getStatement().execute("SELECT P.*, "
                    + "CASE P.SEXO "
                    + "WHEN 'M' THEN 'Masculino' "
                    + "WHEN 'F' THEN 'Feminino' "
                    + " END AS PSEXO "
                    + "FROM PESSOA P");
            //resulSet recebe os valores da query
            JRResultSetDataSource relResult = new JRResultSetDataSource(this.getStatement().getResultSet());
            //jpPrint recebe o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/Pessoa.jasper", new HashMap(), relResult);
            //é retornado o relatorio
            return (new JasperViewer(jpPrint, true));

        } catch (SQLException | JRException ex) {//tratamento de exceções
            DExcecao excecao = new DExcecao(null, true, ex.getMessage());
            excecao.setVisible(true);
        }
        return (null);
    }
}
