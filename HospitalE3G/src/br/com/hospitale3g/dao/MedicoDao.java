package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import static br.com.hospitale3g.dao.Dao.url;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.view.DExcecao;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class MedicoDao extends Dao {
    //constantes com os nomes de cada atributo no banco de dados
    static final String codPessoa = "codPessoa";
    static final String crm = "crm";
    //função que retorna em uma lista, os dados que estão no banco de dados
    public List<Medico> select() {
        String sqlQuery = "SELECT * "
                + "FROM MEDICO";
        //conecta no banco de dados
        this.connect(Dao.url);
        //instancia uma lista de medicos
        List<Medico> medicos = new ArrayList<Medico>();
        ResultSet resultSet;
        try {
            //recebe os dados retornados da query
            resultSet = this.getStatement().executeQuery(sqlQuery);
            while (resultSet.next()) {
                //é criado uma nova instancia de medico de acordo com os dados
                //do resultSet
                int codPessoa = resultSet.getInt(MedicoDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Medico medico = new Medico(pessoa,
                        resultSet.getString(MedicoDao.crm));
                //adiciona o medico na lista
                medicos.add(medico);
            }
            //retorna o medico
            return (medicos);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();//fecha o banco de dados
        }
    }
    //insere medicos
    public void insert(Medico medico) {
        String sqlQuery = "INSERT INTO MEDICO(CODPESSOA, CRM) "
                + "VALUES(" + medico.getCodPessoa() + ", "
                + Lib.quotedStr(medico.getCrm()) + ");";

        this.connect(Dao.url);
        try {
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
    }
    //atualiza medicos
    public void update(Medico medico) {
        String sqlQuery = "UPDATE MEDICO "
                + "SET CODPESSOA = " + medico.getCodPessoa() + ", "
                + " CRM = " + Lib.quotedStr(medico.getCrm()) + " "
                + "WHERE CODPESSOA = " + medico.getCodPessoa();

        this.connect(Dao.url);
        try {
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
    }
    //apaga medicos
    public void delete(int codPessoa) {
        String sqlQuery = "DELETE FROM MEDICO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.connect(Dao.url);
        try {
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
    }
    //seleciona medico
    public Medico getMedico(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM MEDICO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.connect(Dao.url);
        List<Medico> medicos = new ArrayList<Medico>();
        ResultSet resultSet;
        try {
            resultSet = this.getStatement().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(resultSet.getInt(MedicoDao.codPessoa));

                Medico medico = new Medico(pessoa,
                        resultSet.getString(MedicoDao.crm));
                return (medico);
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
    //seleciona medico
    public Medico getMedico(String crm) {
        String sqlQuery = "SELECT * "
                + " FROM MEDICO "
                + " WHERE CRM LIKE " + Lib.quotedStr(crm);

        this.connect(Dao.url);
        List<Medico> medicos = new ArrayList<Medico>();
        ResultSet resultSet;
        try {
            resultSet = this.getStatement().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(resultSet.getInt(MedicoDao.codPessoa));

                Medico medico = new Medico(pessoa,
                        resultSet.getString(MedicoDao.crm));
                return (medico);
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
    //encontra o medico
    public boolean findMedico(String crm) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM MEDICO "
                    + " WHERE CRM LIKE " + Lib.quotedStr(crm);
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica a existencia de um medico
    public boolean existsMedico(int codPessoa) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM MEDICO "
                    + " WHERE CODPESSOA = " + codPessoa + ";";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica a existencia de um medico
    public boolean existsMedico(String crm) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM MEDICO "
                    + " WHERE CRM LIKE " + Lib.quotedStr(crm) + ";";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica se o medico está em atendimento
    public boolean hasDependenceAtendimento(String crm) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT A.* "
                    + " FROM ATENDIMENTO A "
                    + " WHERE A.CRM LIKE " + Lib.quotedStr(crm) + ";";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica se o medico é um usuario
    public boolean hasDependenceUsuario(String crm) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT U.* "
                    + " FROM USUARIO U "
                    + " WHERE U.CODPESSOA = (SELECT M.CODPESSOA"
                    + " FROM MEDICO M "
                    + " WHERE M.CRM LIKE " + Lib.quotedStr(crm) + ");";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //seleciona colunas
    public String[] getColumns() {
        String[] aux = {"Código", "Nome", "CPF", "CRM", "Sexo"};
        return (aux);
    }
    //seleciona o modelo de tabela
    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };

        MedicoDao medicoDao = new MedicoDao();
        for (int i = 0; i <= medicoDao.getColumns().length - 1; i++) {
            String[] aux = medicoDao.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Medico medico : this.select()) {
            model.addRow(new Object[]{medico.getCodPessoa(),
                medico.getNome(),
                medico.getCpf(),
                medico.getCrm(),
                Lib.iif(medico.getSexo() == 'M', "Masculino", "Feminino"),});
        }
        return (model);
    }
    //relatorio
    public JasperViewer getIReport() {
        this.connect(url);
        try {
            this.getStatement().execute("SELECT M.*, P.*, "
                    + "             CASE P.SEXO "
                    + "                WHEN 'M' THEN 'Masculino' "
                    + "                WHEN 'F' THEN 'Feminino' "
                    + "             END AS PSEXO "
                    + "FROM MEDICO M "
                    + "JOIN PESSOA P ON P.CODPESSOA = M.CODPESSOA");
            JRResultSetDataSource relResult = new JRResultSetDataSource(this.getStatement().getResultSet());
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/Medico.jasper", new HashMap(), relResult);
            return (new JasperViewer(jpPrint, true));
        } catch (SQLException | JRException ex) {
            DExcecao excecao = new DExcecao(null, true, ex.getMessage());
            excecao.setVisible(true);
        }
        return (null);
    }
}
