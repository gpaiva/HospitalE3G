package br.com.hospitale3g.controller;

import br.com.hospitale3g.dao.PessoaDao;
import br.com.hospitale3g.model.Pessoa;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.view.JasperViewer;

public class PessoaController {

    public static Connection getConnection() {
        PessoaDao pessoaDao = new PessoaDao();
        return (pessoaDao.getCon());
    }

    public static List<Pessoa> select() {
        PessoaDao pessoaDao = new PessoaDao();
        return (pessoaDao.select());
    }

    public static void insert(Pessoa pessoa) {
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.insert(pessoa);
    }

    public static void update(Pessoa pessoa) {
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.update(pessoa);
    }

    public static void delete(int codPessoa) {
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.delete(codPessoa);
    }

    public static int getNextCodPessoa() {
        PessoaDao pessoaDao = new PessoaDao();
        return (pessoaDao.getNextCodPessoa());
    }

    public static Pessoa getPessoa(int codPessoa) {
        PessoaDao pessoaDao = new PessoaDao();
        return (pessoaDao.getPessoa(codPessoa));
    }

    public static boolean existsPessoaCpf(String cpf) {
        PessoaDao pessoaDao = new PessoaDao();
        return (pessoaDao.existsPessoaCpf(cpf));
    }

    public static boolean existsPessoaRg(String rg) {
        PessoaDao pessoaDao = new PessoaDao();
        return (pessoaDao.existsPessoaRg(rg));
    }

    public static String getPessoa(Pessoa pessoa) {
        PessoaDao pessoaDao = new PessoaDao();
        return (pessoaDao.getPessoa(pessoa));

    }

    public static String[] getColumns() {
        PessoaDao pessoaDao = new PessoaDao();
        return (pessoaDao.getColumns());
    }

    public static DefaultTableModel getTableModel() {
        PessoaDao pessoaDao = new PessoaDao();
        return (pessoaDao.getTableModel());
    }
    
    public static JasperViewer getIReport(){
        PessoaDao pessoaDao = new PessoaDao();
        return(pessoaDao.getIReport());
    }
}
