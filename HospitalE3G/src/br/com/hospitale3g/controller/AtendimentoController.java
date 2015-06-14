package br.com.hospitale3g.controller;

import br.com.hospitale3g.dao.Dao;
import br.com.hospitale3g.dao.AtendimentoDao;
import br.com.hospitale3g.dao.PessoaDao;
import br.com.hospitale3g.model.Atendimento;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.view.DExcecao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AtendimentoController {

    public static List<Atendimento> select() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.select());
    }

    public static void insert(Atendimento atendimento) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.insert(atendimento);
    }

    public static void update(Atendimento atendimento) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.update(atendimento);
    }

    public static void delete(int atenCodigo) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.delete(atenCodigo);
    }

    public static Atendimento getAtendimento(int atenCodigo) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.getAtendimento(atenCodigo));
    }

    public static boolean findAtendimento(int atenCodigo) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.findAtendimento(atenCodigo));
    }

    public static int getNextAtenCodigo() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.getNextAtenCodigo());
    }

    public static String[] getColumns() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.getColumns());
    }

    public static DefaultTableModel getTableModel() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.getTableModel());
    }
}
