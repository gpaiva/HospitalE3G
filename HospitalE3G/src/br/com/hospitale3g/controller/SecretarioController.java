package br.com.hospitale3g.controller;

import br.com.hospitale3g.dao.PacienteDao;
import br.com.hospitale3g.dao.SecretarioDao;
import br.com.hospitale3g.model.Secretario;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.view.JasperViewer;

public class SecretarioController {
    
    public static List<Secretario> select() {
        SecretarioDao secretarioDao = new SecretarioDao();
        return (secretarioDao.select());
    }
    
    public static void insert(Secretario secretario) {
        SecretarioDao secretarioDao = new SecretarioDao();
        secretarioDao.insert(secretario);
    }
    
    public static void update(Secretario secretario) {
        SecretarioDao secretarioDao = new SecretarioDao();
        secretarioDao.update(secretario);
    }
    
    public static void delete(int codPessoa) {
        SecretarioDao secretarioDao = new SecretarioDao();
        secretarioDao.delete(codPessoa);
    }
    
    public static Secretario getSecretario(int codPessoa) {
        SecretarioDao secretarioDao = new SecretarioDao();
        return (secretarioDao.getSecretario(codPessoa));
    }
    
    public static boolean findSecretario(int registro) {
        SecretarioDao secretarioDao = new SecretarioDao();
        return (secretarioDao.findSecretario(registro));
    }
    
    public static boolean existsSecretario(int registro) {
        SecretarioDao secretarioDao = new SecretarioDao();
        return (secretarioDao.existsSecretario(registro));
    }
    
    public static boolean hasDependenceUsuario(int registro) {
        SecretarioDao secretarioDao = new SecretarioDao();
        return (secretarioDao.hasDependenceUsuario(registro));
    }
    
    public static int getNextRegistro() {
        SecretarioDao secretarioDao = new SecretarioDao();
        return (secretarioDao.getNextRegistro());
    }
    
    public static String[] getColumns() {
        SecretarioDao secretarioDao = new SecretarioDao();
        return (secretarioDao.getColumns());
    }
    
    public static DefaultTableModel getTableModel() {
        SecretarioDao secretarioDao = new SecretarioDao();
        return (secretarioDao.getTableModel());
    }
    
    public static JasperViewer getIReport() {
        SecretarioDao secretarioDao = new SecretarioDao();
        return (secretarioDao.getIReport());
    }
}
