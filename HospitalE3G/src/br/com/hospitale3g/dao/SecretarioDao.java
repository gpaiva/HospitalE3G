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
    //constantes com os nomes de cada atributo no banco de dados
    static final String codPessoa = "codPessoa";
    static final String registro = "registro";
    //função que retorna em uma lista, os dados que estão no banco de dados
    public List<Secretario> select() {
        String sqlQuery = "SELECT * "
                + "FROM SECRETARIO";
        //conecta com o bd
        this.connect(Dao.url);
        //instancia uma lista de secretarios
        List<Secretario> secretarios = new ArrayList<Secretario>();
        ResultSet resultSet;
        try {
            //recebe dados retornados da query
            resultSet = this.getStatement().executeQuery(sqlQuery);
            while (resultSet.next()) {
                //é criado uma nova instancia de secretario de acordo com os dados
                //do resultSet
                int codPessoa = resultSet.getInt(SecretarioDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Secretario secretario = new Secretario(pessoa,
                        resultSet.getInt(SecretarioDao.registro));
                //adiciona o secretario na lista de secretarios
                secretarios.add(secretario);
            }
            //retorna a lista de secretarios
            return (secretarios);
        } catch (SQLException e) {//tratamento de exceções
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();//fecha o bd
        }
    }
    //insere um secretario
    public void insert(Secretario secretario) {
        String sqlQuery = "INSERT INTO SECRETARIO(CODPESSOA, REGISTRO) "
                + "VALUES(" + secretario.getCodPessoa() + ", "
                + secretario.getRegistro() + ");";

        this.connect(Dao.url);
        try {
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
    }
    //atualiza um secretario
    public void update(Secretario secretario) {
        String sqlQuery = "UPDATE SECRETARIO "
                + "SET CODPESSOA = " + secretario.getCodPessoa() + ", "
                + " REGISTRO = " + secretario.getRegistro() + " "
                + "WHERE CODPESSOA = " + secretario.getCodPessoa();

        this.connect(Dao.url);
        try {
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
    }
    //deleta um secretario
    public void delete(int codPessoa) {
        String sqlQuery = "DELETE FROM SECRETARIO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.connect(Dao.url);
        try {
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
    }
    //recebe um secretario
    public Secretario getSecretario(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM SECRETARIO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.connect(Dao.url);
        List<Secretario> secretarios = new ArrayList<Secretario>();
        ResultSet resultSet;
        try {
            resultSet = this.getStatement().executeQuery(sqlQuery);
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
    //encontra um secretario
    public boolean findSecretario(int registro) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM SECRETARIO "
                    + " WHERE REGISTRO = " + registro;
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica a existencia de um secretario
    public boolean existsSecretario(int registro) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM SECRETARIO "
                    + " WHERE REGISTRO = " + registro;
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //recebe o proximo registro de secretario
    public int getNextRegistro() {
        int aux = -1;
        String sqlQuery = "SELECT COALESCE(MAX(REGISTRO), 0) + 1 AS REGISTRO "
                + " FROM SECRETARIO ";

        this.connect(Dao.url);
        try {
            ResultSet rs = this.getStatement().executeQuery(sqlQuery);
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
    //verifica a se é um usuario
    public boolean hasDependenceUsuario(int registro) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT U.* "
                    + " FROM USUARIO U "
                    + " WHERE U.CODPESSOA = (SELECT S.CODPESSOA"
                    + " FROM SECRETARIO S "
                    + " WHERE S.REGISTRO = " + registro + ");";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
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
    //relatorio
    public JasperViewer getIReport() {
        this.connect(url);
        try {
            this.getStatement().execute("SELECT S.*, P.*, "
                    + "             CASE P.SEXO "
                    + "                WHEN 'M' THEN 'Masculino' "
                    + "                WHEN 'F' THEN 'Feminino' "
                    + "             END AS PSEXO "
                    + "FROM SECRETARIO S "
                    + "JOIN PESSOA P ON P.CODPESSOA = S.CODPESSOA");
            JRResultSetDataSource relResult = new JRResultSetDataSource(this.getStatement().getResultSet());
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/Secretario.jasper", new HashMap(), relResult);
            return (new JasperViewer(jpPrint, true));
        } catch (SQLException | JRException ex) {
            DExcecao excecao = new DExcecao(null, true, ex.getMessage());
            excecao.setVisible(true);
        }
        return (null);
    }
}
