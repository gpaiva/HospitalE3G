package br.com.hospitale3g.controller;

import br.com.hospitale3g.dao.Dao;
import br.com.hospitale3g.dao.MedicoDao;
import br.com.hospitale3g.model.Medico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.view.JasperViewer;

public class MedicoController {

    public static List<Medico> select() {
        MedicoDao medicoDao = new MedicoDao();
        return (medicoDao.select());
    }

    public static void insert(Medico medico) {
        MedicoDao medicoDao = new MedicoDao();
        medicoDao.insert(medico);
    }

    public static void update(Medico medico) {
        MedicoDao medicoDao = new MedicoDao();
        medicoDao.update(medico);
    }

    public static void delete(int codPessoa) {
        MedicoDao medicoDao = new MedicoDao();
        medicoDao.delete(codPessoa);
    }

    public static Medico getMedico(int codPessoa) {
        MedicoDao medicoDao = new MedicoDao();
        return (medicoDao.getMedico(codPessoa));
    }

    public static Medico getMedico(String crm) {
        MedicoDao medicoDao = new MedicoDao();
        return (medicoDao.getMedico(crm));
    }

    public static boolean findMedico(String crm) {
        MedicoDao medicoDao = new MedicoDao();
        return (medicoDao.findMedico(crm));
    }

    public static boolean existsMedico(int codPessoa) {
        MedicoDao medicoDao = new MedicoDao();
        return (medicoDao.existsMedico(codPessoa));
    }

    public static boolean existsMedico(String crm) {
        MedicoDao medicoDao = new MedicoDao();
        return (medicoDao.existsMedico(crm));
    }

    public static String[] getColumns() {
        MedicoDao medicoDao = new MedicoDao();
        return (medicoDao.getColumns());
    }

    public static DefaultTableModel getTableModel() {
        MedicoDao medicoDao = new MedicoDao();
        return (medicoDao.getTableModel());
    }

    public static JasperViewer getIReport() {
        MedicoDao medicoDao = new MedicoDao();
        return (medicoDao.getIReport());
    }
}
