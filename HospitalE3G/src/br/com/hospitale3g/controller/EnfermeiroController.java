package br.com.hospitale3g.controller;

import br.com.hospitale3g.dao.Dao;
import br.com.hospitale3g.dao.EnfermeiroDao;
import br.com.hospitale3g.model.Enfermeiro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EnfermeiroController {

    public static List<Enfermeiro> select() {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        return (enfermeiroDao.select());
    }

    public static void insert(Enfermeiro enfermeiro) {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        enfermeiroDao.insert(enfermeiro);
    }

    public static void update(Enfermeiro enfermeiro) {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        enfermeiroDao.update(enfermeiro);
    }

    public static void delete(int codPessoa) {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        enfermeiroDao.delete(codPessoa);
    }

    public static Enfermeiro getEnfermeiro(int codPessoa) {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        return (enfermeiroDao.getEnfermeiro(codPessoa));
    }
    
    public static Enfermeiro getEnfermeiro(String coren) {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        return (enfermeiroDao.getEnfermeiro(coren));
    }

    public static boolean findEnfermeiro(String coren) {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        return (enfermeiroDao.findEnfermeiro(coren));
    }
     public static boolean existsEnfermeiro(int codPessoa) {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        return (enfermeiroDao.existsEnfermeiro(codPessoa));
    }
     
     public static boolean existsEnfermeiro(String coren) {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        return (enfermeiroDao.existsEnfermeiro(coren));
    }

    public static String[] getColumns() {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        return (enfermeiroDao.getColumns());
    }

    public static DefaultTableModel getTableModel() {
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        return (enfermeiroDao.getTableModel());
    }
}
