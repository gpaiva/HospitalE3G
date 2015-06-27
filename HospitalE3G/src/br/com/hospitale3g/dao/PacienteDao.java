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

    static final String codPessoa = "codPessoa";
    static final String id = "id";

    public List<Paciente> select() {
        String sqlQuery = "SELECT * "
                + "FROM PACIENTE";

        this.connect(Dao.url);
        List<Paciente> pacientes = new ArrayList<Paciente>();
        ResultSet resultSet;
        try {
            resultSet = this.getStatement().executeQuery(sqlQuery);
            while (resultSet.next()) {
                int codPessoa = resultSet.getInt(PacienteDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Paciente paciente = new Paciente(pessoa,
                        resultSet.getInt(PacienteDao.id));
                pacientes.add(paciente);
            }
            return (pacientes);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

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
