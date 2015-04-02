package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.Usuario;

public class DaoUsuario extends Dao {

    public List<Usuario> select() {
        this.conectar();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet rs;
        try {
            rs = this.getComando().executeQuery("SELECT * "
                    + "FROM USUARIO");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setPesCodigo(Integer.parseInt(rs.getString("PESCODIGO")));
                usuario.setUsuLogin(rs.getString("USULOGIN"));
                usuario.setUsuSenha(rs.getString("USUSENHA"));
                usuarios.add(usuario);
            }
            return (usuarios);
        } catch (SQLException e) {
            System.err.println("Erro ao buscar Usuários");
            return (null);
        } finally {
            this.fechar();
        }
    }

    public void insert(Usuario usuario) {
        this.conectar();
        try {
            this.getComando().executeUpdate("INSERT INTO USUARIO(PESCODIGO, USULOGIN, USUSENHA) "
                    + "VALUES('" + usuario.getPesCodigo()
                    + "', '" + usuario.getUsuLogin()
                    + "', '" + usuario.getUsuSenha() + "')");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Usuário");
        } finally {
            this.fechar();
        }
    }

    public void update(Usuario usuario) {
        this.conectar();
        try {
            this.getComando().executeUpdate("UPDATE USUARIO "
                    + "SET PESCODIGO = " + usuario.getPesCodigo() + ", "
                    + " USULOGIN = '" + usuario.getUsuLogin() + "', "
                    + " USUSENHA = '" + usuario.getUsuSenha() + "' "
                    + " WHERE PESCODIGO = " + usuario.getPesCodigo());
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Usuários");
        } finally {
            this.fechar();
        }
    }

    public void delete(int pesCodigo) {
        this.conectar();
        try {
            this.getComando().executeUpdate("DELETE FROM USUARIO "
                    + "WHERE PESCODIGO = " + pesCodigo);
        } catch (SQLException e) {
            System.err.println("Erro ao apagar Usuário");
        } finally {
            this.fechar();
        }
    }

    public boolean findUsuario(String usuLogin, String usuSenha) {
        this.conectar();
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
            this.fechar();
        }
        return (false);
    }
}
