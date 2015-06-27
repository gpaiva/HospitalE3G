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
import net.sf.jasperreports.view.JasperViewer;

public class AtendimentoController {
    //função que retorna em uma lista, os dados que estão no banco de dados
    public static List<Atendimento> select() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.select());
    }
    //insere um etendimento
    public static void insert(Atendimento atendimento) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.insert(atendimento);
    }
    //atualiza um atendimento
    public static void update(Atendimento atendimento) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.update(atendimento);
    }
    //deleta um atendimento
    public static void delete(int atenCodigo) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.delete(atenCodigo);
    }
    //retorna um atendimento
    public static Atendimento getAtendimento(int atenCodigo) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.getAtendimento(atenCodigo));
    }
    //encontra um atendimento
    public static boolean findAtendimento(int atenCodigo) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.findAtendimento(atenCodigo));
    }
    //retorna o próximo atendimento
    public static int getNextAtenCodigo() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.getNextAtenCodigo());
    }
    //retorna as colunas do atendimento
    public static String[] getColumns() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.getColumns());
    }
    //retorna a tabela atendimento
    public static DefaultTableModel getTableModel() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.getTableModel());
    }
    //retorna um relatório
    public static JasperViewer getIReport() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return (atendimentoDao.getIReport());
    }
}
