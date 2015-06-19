package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import static br.com.hospitale3g.dao.Dao.url;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Secretario;
import br.com.hospitale3g.view.DExcecao;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class SecretarioDao extends Dao {

    static final String codPessoa = "codPessoa";
    static final String registro = "registro";

    public List<Secretario> select() {
        String sqlQuery = "SELECT * "
                + "FROM SECRETARIO";

        this.conect(Dao.url);
        List<Secretario> secretarios = new ArrayList<Secretario>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            while (resultSet.next()) {
                int codPessoa = resultSet.getInt(SecretarioDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Secretario secretario = new Secretario(pessoa,
                        resultSet.getInt(SecretarioDao.registro));
                secretarios.add(secretario);
            }
            return (secretarios);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    public void insert(Secretario secretario) {
        String sqlQuery = "INSERT INTO SECRETARIO(CODPESSOA, REGISTRO) "
                + "VALUES(" + secretario.getCodPessoa() + ", "
                + secretario.getRegistro() + ");";

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

    public void update(Secretario secretario) {
        String sqlQuery = "UPDATE SECRETARIO "
                + "SET CODPESSOA = " + secretario.getCodPessoa() + ", "
                + " REGISTRO = " + secretario.getRegistro() + " "
                + "WHERE CODPESSOA = " + secretario.getCodPessoa();

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
        String sqlQuery = "DELETE FROM SECRETARIO "
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

    public Secretario getSecretario(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM SECRETARIO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.conect(Dao.url);
        List<Secretario> secretarios = new ArrayList<Secretario>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(resultSet.getInt(SecretarioDao.codPessoa));

                Secretario secretario = new Secretario(pessoa,
                        resultSet.getInt(SecretarioDao.registro));
                return (secretario);
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

    public boolean findSecretario(int registro) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM SECRETARIO "
                    + " WHERE REGISTRO = " + registro;
            ResultSet resultSet = this.getComando().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    public boolean existsSecretario(int registro) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM SECRETARIO "
                    + " WHERE REGISTRO = " + registro;
            ResultSet resultSet = this.getComando().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }

    public int getNextRegistro() {
        int aux = -1;
        String sqlQuery = "SELECT COALESCE(MAX(REGISTRO), 0) + 1 AS REGISTRO "
                + " FROM SECRETARIO ";

        this.conect(Dao.url);
        try {
            ResultSet rs = this.getComando().executeQuery(sqlQuery);
            while (rs.next()) {
                aux = rs.getInt("REGISTRO");
            }
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
        return (aux);
    }

    public String[] getColumns() {
        String[] aux = {"Código", "Nome", "CPF", "Registro", "Sexo"};
        return (aux);
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };

        SecretarioDao secretarioDao = new SecretarioDao();
        for (int i = 0; i <= secretarioDao.getColumns().length - 1; i++) {
            String[] aux = secretarioDao.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Secretario secretario : this.select()) {
            model.addRow(new Object[]{secretario.getCodPessoa(),
                secretario.getNome(),
                secretario.getCpf(),
                secretario.getRegistro(),
                Lib.iif(secretario.getSexo() == 'M', "Masculino", "Feminino")});
        }
        return (model);
    }
    
     public JasperViewer getIReport() {
        this.conect(url);
        try {
            this.getComando().execute("SELECT S.*, P.*, "
                    + "             CASE P.SEXO "
                    + "                WHEN 'M' THEN 'Masculino' "
                    + "                WHEN 'F' THEN 'Feminino' "
                    + "             END AS PSEXO "
                    + "FROM SECRETARIO S "
                    + "JOIN PESSOA P ON P.CODPESSOA = S.CODPESSOA");
            JRResultSetDataSource relResult = new JRResultSetDataSource(this.getComando().getResultSet());
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/Secretario.jasper", new HashMap(), relResult);
            return (new JasperViewer(jpPrint, true));
        } catch (SQLException | JRException ex) {
            DExcecao excecao = new DExcecao(null, true, ex.getMessage());
            excecao.setVisible(true);
        }
        return (null);
    }
}
