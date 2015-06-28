package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import static br.com.hospitale3g.dao.Dao.url;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Paciente;
import br.com.hospitale3g.view.DExcecao;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class PacienteDao extends Dao {
    //constantes com os nomes de cada atributo no banco de dados
    static final String codPessoa = "codPessoa";
    static final String id = "id";
        //função que retorna em uma lista, os dados que estão no banco de dados
    public List<Paciente> select() {
        String sqlQuery = "SELECT * "
                + "FROM PACIENTE";
        //conecta no banco de dados
        this.connect(Dao.url);
        //instancia uma lista de pacientes
        List<Paciente> pacientes = new ArrayList<Paciente>();
        ResultSet resultSet;
        try {
            //recebe os dados retornados da query
            resultSet = this.getStatement().executeQuery(sqlQuery);
            while (resultSet.next()) {
                //é criado uma nova instancia de paciente de acordo com os dados
                //do resultSet
                int codPessoa = resultSet.getInt(PacienteDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Paciente paciente = new Paciente(pessoa,
                        resultSet.getInt(PacienteDao.id));
                //adiciona o paciente na lista de pacientes
                pacientes.add(paciente);
            }
            //retorna lista de pacientes
            return (pacientes);
        } catch (SQLException e) {//tratamento de exceções
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();//fecha o bd
        }
    }
    //insere pacientes
    public void insert(Paciente paciente) {
        String sqlQuery = "INSERT INTO PACIENTE(CODPESSOA, ID) "
                + "VALUES(" + paciente.getCodPessoa() + ", "
                + paciente.getId() + ");";

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
    //atualiza pacientes
    public void update(Paciente paciente) {
        String sqlQuery = "UPDATE PACIENTE "
                + "SET CODPESSOA = " + paciente.getCodPessoa() + ", "
                + " ID = " + paciente.getId() + " "
                + "WHERE CODPESSOA = " + paciente.getCodPessoa();

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
    //deleta pacientes
    public void delete(int codPessoa) {
        String sqlQuery = "DELETE FROM PACIENTE "
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
    //recebe um paciente
    public Paciente getPaciente(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM PACIENTE "
                + " WHERE CODPESSOA = " + codPessoa;

        this.connect(Dao.url);
        List<Paciente> pacientes = new ArrayList<Paciente>();
        ResultSet resultSet;
        try {
            resultSet = this.getStatement().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(resultSet.getInt(PacienteDao.codPessoa));

                Paciente paciente = new Paciente(pessoa,
                        resultSet.getInt(PacienteDao.id));
                return (paciente);
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
    //recebe um paciente
    public Paciente getPacienteId(int id) {
        String sqlQuery = "SELECT * "
                + " FROM PACIENTE "
                + " WHERE ID = " + id;

        this.connect(Dao.url);
        List<Paciente> pacientes = new ArrayList<Paciente>();
        ResultSet resultSet;
        try {
            resultSet = this.getStatement().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(resultSet.getInt(PacienteDao.codPessoa));

                Paciente paciente = new Paciente(pessoa,
                        resultSet.getInt(PacienteDao.id));
                return (paciente);
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
    //encontra paciente
    public boolean findPaciente(int id) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM PACIENTE "
                    + " WHERE ID LIKE " + id;
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica a existencia de um paciente
    public boolean existsPaciente(int id) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM PACIENTE "
                    + " WHERE ID = " + id;
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //recebe o proximo id
    public int getNextId() {
        int aux = -1;
        String sqlQuery = "SELECT COALESCE(MAX(ID), 0) + 1 AS ID "
                + " FROM PACIENTE ";

        this.connect(Dao.url);
        try {
            ResultSet rs = this.getStatement().executeQuery(sqlQuery);
            while (rs.next()) {
                aux = rs.getInt("ID");
            }
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
        return (aux);
    }
    //verifica se o paciente está sendo atendido
    public boolean hasDependenceAtendimento(int id) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT A.* "
                    + " FROM ATENDIMENTO A "
                    + " WHERE A.ID = " + id + ";";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    public String[] getColumns() {
        String[] aux = {"Código", "Nome", "CPF", "ID", "Sexo"};
        return (aux);
    }
    
    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };

        PacienteDao pacienteDao = new PacienteDao();
        for (int i = 0; i <= pacienteDao.getColumns().length - 1; i++) {
            String[] aux = pacienteDao.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Paciente paciente : this.select()) {
            model.addRow(new Object[]{paciente.getCodPessoa(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getId(),
                Lib.iif(paciente.getSexo() == 'M', "Masculino", "Feminino")});
        }
        return (model);
    }
    //relatorio
    public JasperViewer getIReport() {
        this.connect(url);
        try {
            this.getStatement().execute("SELECT PA.*, P.*, "
                    + "             CASE P.SEXO "
                    + "                WHEN 'M' THEN 'Masculino' "
                    + "                WHEN 'F' THEN 'Feminino' "
                    + "             END AS PSEXO "
                    + "FROM PACIENTE PA "
                    + "JOIN PESSOA P ON P.CODPESSOA = PA.CODPESSOA");
            JRResultSetDataSource relResult = new JRResultSetDataSource(this.getStatement().getResultSet());
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/Paciente.jasper", new HashMap(), relResult);
            return (new JasperViewer(jpPrint, true));
        } catch (SQLException | JRException ex) {
            DExcecao excecao = new DExcecao(null, true, ex.getMessage());
            excecao.setVisible(true);
        }
        return (null);
    }

}
