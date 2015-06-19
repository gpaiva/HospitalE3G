package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import static br.com.hospitale3g.dao.Dao.url;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Enfermeiro;
import br.com.hospitale3g.view.DExcecao;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class EnfermeiroDao extends Dao {

    static final String codPessoa = "codPessoa";
    static final String coren = "coren";

    public List<Enfermeiro> select() {
        String sqlQuery = "SELECT * "
                + "FROM ENFERMEIRO";

        this.conect(Dao.url);
        List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            while (resultSet.next()) {
                int codPessoa = resultSet.getInt(EnfermeiroDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Enfermeiro enfermeiro = new Enfermeiro(pessoa,
                        resultSet.getString(EnfermeiroDao.coren));
                enfermeiros.add(enfermeiro);
            }
            return (enfermeiros);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    public void insert(Enfermeiro enfermeiro) {
        String sqlQuery = "INSERT INTO ENFERMEIRO(CODPESSOA, COREN) "
                + "VALUES(" + enfermeiro.getCodPessoa() + ", "
                + Lib.quotedStr(enfermeiro.getCoren()) + ");";

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

    public void update(Enfermeiro enfermeiro) {
        String sqlQuery = "UPDATE ENFERMEIRO "
                + "SET CODPESSOA = " + enfermeiro.getCodPessoa() + ", "
                + " COREN = " + Lib.quotedStr(enfermeiro.getCoren()) + " "
                + "WHERE CODPESSOA = " + enfermeiro.getCodPessoa();

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
        String sqlQuery = "DELETE FROM ENFERMEIRO "
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

    public Enfermeiro getEnfermeiro(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM ENFERMEIRO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.conect(Dao.url);
        List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(resultSet.getInt(EnfermeiroDao.codPessoa));

                Enfermeiro enfermeiro = new Enfermeiro(pessoa,
                        resultSet.getString(EnfermeiroDao.coren));
                return (enfermeiro);
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

    public Enfermeiro getEnfermeiro(String coren) {
        String sqlQuery = "SELECT * "
                + " FROM ENFERMEIRO "
                + " WHERE COREN LIKE " + Lib.quotedStr(coren);

        this.conect(Dao.url);
        List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(resultSet.getInt(EnfermeiroDao.codPessoa));

                Enfermeiro enfermeiro = new Enfermeiro(pessoa,
                        resultSet.getString(EnfermeiroDao.coren));
                return (enfermeiro);
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

    public boolean findEnfermeiro(String coren) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM ENFERMEIRO "
                    + " WHERE COREN LIKE " + Lib.quotedStr(coren);
            ResultSet resultSet = this.getComando().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }

    public boolean existsEnfermeiro(int codPessoa) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM ENFERMEIRO "
                    + " WHERE CODPESSOA = " + codPessoa + ";";
            ResultSet result = this.getComando().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }

    public boolean existsEnfermeiro(String coren) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM ENFERMEIRO "
                    + " WHERE COREN LIKE " + Lib.quotedStr(coren) + ";";
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
        String[] aux = {"Código", "Nome", "CPF", "COREN", "Sexo"};
        return (aux);
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };

        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        for (int i = 0; i <= enfermeiroDao.getColumns().length - 1; i++) {
            String[] aux = enfermeiroDao.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Enfermeiro enfermeiro : this.select()) {
            model.addRow(new Object[]{enfermeiro.getCodPessoa(),
                enfermeiro.getNome(),
                enfermeiro.getCpf(),
                enfermeiro.getCoren(),
                Lib.iif(enfermeiro.getSexo() == 'M', "Masculino", "Feminino")});
        }
        return (model);
    }

    public JasperViewer getIReport() {
        this.conect(url);
        try {
            this.getComando().execute("SELECT E.*, P.*, "
                    + "             CASE P.SEXO "
                    + "                WHEN 'M' THEN 'Masculino' "
                    + "                WHEN 'F' THEN 'Feminino' "
                    + "             END AS PSEXO "
                    + "FROM ENFERMEIRO E "
                    + "JOIN PESSOA P ON P.CODPESSOA = E.CODPESSOA");
            JRResultSetDataSource relResult = new JRResultSetDataSource(this.getComando().getResultSet());
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/Enfermeiro.jasper", new HashMap(), relResult);
            return (new JasperViewer(jpPrint, true));
        } catch (SQLException | JRException ex) {
            DExcecao excecao = new DExcecao(null, true, ex.getMessage());
            excecao.setVisible(true);
        }
        return (null);
    }
}
