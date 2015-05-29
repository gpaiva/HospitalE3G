package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Paciente;
import br.com.hospitale3g.view.DExcecao;

public class PacienteDao extends Dao {

    static final String codPessoa = "codPessoa";
    static final String id = "id";

    public List<Paciente> select() {
        String sqlQuery = "SELECT * "
                + "FROM PACIENTE";

        this.conect(Dao.url);
        List<Paciente> pacientes = new ArrayList<Paciente>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
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

        this.conect(Dao.url);
        try {
            this.getComando().executeUpdate(sqlQuery);
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

        this.conect(Dao.url);
        try {
            this.getComando().executeUpdate(sqlQuery);
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

        this.conect(Dao.url);
        try {
            this.getComando().executeUpdate(sqlQuery);
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

        this.conect(Dao.url);
        List<Paciente> pacientes = new ArrayList<Paciente>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
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
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM PACIENTE "
                    + " WHERE ID LIKE " + id;
            ResultSet resultSet = this.getComando().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }

    public String[] getColumns() {
        String[] aux = {"Código", "ID"};
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
            model.addRow(new Object[]{paciente.getCodPessoa(), paciente.getId()});
        }
        return (model);
    }
}
