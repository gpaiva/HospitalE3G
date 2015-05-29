package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Usuario;
import br.com.hospitale3g.view.DExcecao;

public class UsuarioDao extends Dao {

    static final String codPessoa = "codPessoa";
    static final String usuLogin = "usuLogin";
    static final String usuSenha = "usuSenha";

    public List<Usuario> select() {
        String sqlQuery = "SELECT * "
                + "FROM USUARIO";

        this.conect(Dao.url);
        List<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet rs1;
        try {
            rs1 = this.getComando().executeQuery(sqlQuery);
            while (rs1.next()) {
                int codPessoa = rs1.getInt(UsuarioDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Usuario usuario = new Usuario(pessoa,
                        rs1.getString(UsuarioDao.usuLogin),
                        rs1.getString(UsuarioDao.usuSenha));
                usuarios.add(usuario);
            }
            return (usuarios);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    public void insert(Usuario usuario) {
        String sqlQuery = "INSERT INTO USUARIO(CODPESSOA, USULOGIN, USUSENHA) "
                + "VALUES(" + usuario.getCodPessoa() + ", "
                + Lib.quotedStr(usuario.getUsuLogin()) + ", "
                + Lib.quotedStr(usuario.getUsuSenha()) + ");";

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

    public void update(Usuario usuario) {
        String sqlQuery = "UPDATE USUARIO "
                + "SET CODPESSOA = " + usuario.getCodPessoa() + ", "
                + " USULOGIN = " + Lib.quotedStr(usuario.getUsuLogin()) + ", "
                + " USUSENHA = " + Lib.quotedStr(usuario.getUsuSenha()) + " "
                + "WHERE CODPESSOA = " + usuario.getCodPessoa();

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
        String sqlQuery = "DELETE FROM USUARIO "
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

    public Usuario getUsuario(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM USUARIO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.conect(Dao.url);
        List<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet rs;
        try {
            rs = this.getComando().executeQuery(sqlQuery);
            if ((rs != null) && (rs.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(rs.getInt(UsuarioDao.codPessoa));

                Usuario usuario = new Usuario(pessoa,
                        rs.getString(UsuarioDao.usuLogin),
                        rs.getString(UsuarioDao.usuSenha));
                return (usuario);
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

    public boolean findUsuario(String usuLogin, String usuSenha) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM USUARIO "
                    + " WHERE USULOGIN LIKE '" + usuLogin + "' AND "
                    + " USUSENHA LIKE '" + usuSenha + "'";
            ResultSet result = this.getComando().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }

    public String[] getColumns() {
        String[] aux = {"Código", "Login"};
        return (aux);
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };
        UsuarioDao daoUsuario = new UsuarioDao();
        for (int i = 0; i <= daoUsuario.getColumns().length - 1; i++) {
            String[] aux = daoUsuario.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Usuario usuario : this.select()) {
            model.addRow(new Object[]{usuario.getCodPessoa(), usuario.getUsuLogin()});
        }
        return (model);
    }
}
