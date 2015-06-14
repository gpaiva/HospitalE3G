package br.com.hospitale3g.controller;

import br.com.hospitale3g.dao.UsuarioDao;
import br.com.hospitale3g.model.Enfermeiro;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.model.Paciente;
import br.com.hospitale3g.model.Secretario;
import br.com.hospitale3g.model.Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsuarioController {

    public static List<Usuario> select() {
        UsuarioDao usuarioDao = new UsuarioDao();
        return (usuarioDao.select());
    }

    public static void insert(Usuario usuario) {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.insert(usuario);
    }

    public static void update(Usuario usuario) {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.update(usuario);
    }

    public static void delete(int codPessoa) {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.delete(codPessoa);
    }

    public static Usuario getUsuario(int codPessoa) {
        UsuarioDao usuarioDao = new UsuarioDao();
        return (usuarioDao.getUsuario(codPessoa));
    }

    public static Usuario getUsuario(String usuLogin, String usuSenha) {
        UsuarioDao usuarioDao = new UsuarioDao();
        return (usuarioDao.getUsuario(usuLogin, usuSenha));
    }

    public static boolean findUsuario(String usuLogin, String usuSenha) {
        UsuarioDao usuarioDao = new UsuarioDao();
        return (usuarioDao.findUsuario(usuLogin, usuSenha));
    }

    public static boolean existsUsuarioCodPessoa(int codPessoa) {
        UsuarioDao usuarioDao = new UsuarioDao();
        return (usuarioDao.existsUsuarioCodPessoa(codPessoa));
    }

    public static String getPrivilegio(Usuario usuario) {
        UsuarioDao usuarioDao = new UsuarioDao();
        return (usuarioDao.getPrivilegio(usuario));
    }

    public static String[] getColumns() {
        UsuarioDao usuarioDao = new UsuarioDao();
        return (usuarioDao.getColumns());
    }

    public static DefaultTableModel getTableModel() {
        UsuarioDao usuarioDao = new UsuarioDao();
        return (usuarioDao.getTableModel());
    }
}
