package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Secretario;
import br.com.hospitale3g.view.DExcecao;

public class SecretarioDao extends Dao {

    static final String codPessoa = "codPessoa";
    static final String registro = "registro";

    public List<Secretario> select() {
        String sqlQuery = "SELECT * "
                + "FROM SECRETARIO";

        this.conect(Dao.url);
        List<Secretario> secretarios = new ArrayList<Secretario>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            while (resultSet.next()) {
                int codPessoa = resultSet.getInt(SecretarioDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Secretario secretario = new Secretario(pessoa,
                        resultSet.getInt(SecretarioDao.registro));
                secretarios.add(secretario);
            }
            return (secretarios);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    public void insert(Secretario secretario) {
        String sqlQuery = "INSERT INTO MEDICO(CODPESSOA, REGISTRO) "
                + "VALUES(" + secretario.getCodPessoa() + ", "
                + secretario.getRegistro() + ");";

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

    public void update(Secretario secretario) {
        String sqlQuery = "UPDATE SECRETARIO "
                + "SET CODPESSOA = " + secretario.getCodPessoa() + ", "
                + " REGISTRO = " + secretario.getRegistro() + " "
                + "WHERE CODPESSOA = " + secretario.getCodPessoa();

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
        String sqlQuery = "DELETE FROM SECRETARIO "
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

    public Secretario getSecretario(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM SECRETARIO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.conect(Dao.url);
        List<Secretario> secretarios = new ArrayList<Secretario>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(resultSet.getInt(SecretarioDao.codPessoa));

                Secretario secretario = new Secretario(pessoa,
                        resultSet.getInt(SecretarioDao.registro));
                return (secretario);
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

    public boolean findMedico(int registro) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM SECRETARIO "
                    + " WHERE REGISTRO LIKE " + registro;
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
        String[] aux = {"Código", "Registro"};
        return (aux);
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };

        SecretarioDao secretarioDao = new SecretarioDao();
        for (int i = 0; i <= secretarioDao.getColumns().length - 1; i++) {
            String[] aux = secretarioDao.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Secretario secretario : this.select()) {
            model.addRow(new Object[]{secretario.getCodPessoa(), secretario.getRegistro()});
        }
        return (model);
    }
}