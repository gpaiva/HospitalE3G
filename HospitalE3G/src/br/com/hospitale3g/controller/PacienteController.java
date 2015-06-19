package br.com.hospitale3g.controller;

import br.com.hospitale3g.dao.PacienteDao;
import br.com.hospitale3g.model.Paciente;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.view.JasperViewer;

public class PacienteController {

    public static List<Paciente> select() {
        PacienteDao pacienteDao = new PacienteDao();
        return (pacienteDao.select());
    }

    public static void insert(Paciente paciente) {
        PacienteDao pacienteDao = new PacienteDao();
        pacienteDao.insert(paciente);
    }

    public static void update(Paciente paciente) {
        PacienteDao pacienteDao = new PacienteDao();
        pacienteDao.update(paciente);
    }

    public static void delete(int codPessoa) {
        PacienteDao pacienteDao = new PacienteDao();
        pacienteDao.delete(codPessoa);
    }

    public static Paciente getPaciente(int codPessoa) {
        PacienteDao pacienteDao = new PacienteDao();
        return (pacienteDao.getPaciente(codPessoa));
    }

    public static Paciente getPacienteId(int id) {
        PacienteDao pacienteDao = new PacienteDao();
        return (pacienteDao.getPacienteId(id));
    }

    public static boolean findPaciente(int id) {
        PacienteDao pacienteDao = new PacienteDao();
        return (pacienteDao.findPaciente(id));
    }

    public static boolean existsPaciente(int id) {
        PacienteDao pacienteDao = new PacienteDao();
        return (pacienteDao.findPaciente(id));
    }

    public static int getNextId() {
        PacienteDao pacienteDao = new PacienteDao();
        return (pacienteDao.getNextId());
    }

    public static String[] getColumns() {
        PacienteDao pacienteDao = new PacienteDao();
        return (pacienteDao.getColumns());
    }

    public static DefaultTableModel getTableModel() {
        PacienteDao pacienteDao = new PacienteDao();
        return (pacienteDao.getTableModel());
    }

    public static JasperViewer getIReport() {
        PacienteDao pacienteDao = new PacienteDao();
        return (pacienteDao.getIReport());
    }
}
