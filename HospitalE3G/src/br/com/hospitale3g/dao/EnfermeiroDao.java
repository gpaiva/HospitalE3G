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
    //constantes com os nomes de cada atributo no banco de dados
    static final String codPessoa = "codPessoa";
    static final String coren = "coren";

    //função que retorna em uma lista, os dados que estão no banco de dados
    public List<Enfermeiro> select() {
        String sqlQuery = "SELECT * "
                + "FROM ENFERMEIRO";
        //conecta no banco de dados
        this.connect(Dao.url);
        //instancia uma lista de enfermeiros
        List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
        ResultSet resultSet;
        try {
            //recebe os dados retornados da query
            resultSet = this.getStatement().executeQuery(sqlQuery);
            //caso ainda houver proximo no resultSet
            while (resultSet.next()) {
                int codPessoa = resultSet.getInt(EnfermeiroDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Enfermeiro enfermeiro = new Enfermeiro(pessoa,
                        resultSet.getString(EnfermeiroDao.coren));
                //adiciona a pessoa na lista de pessoas
                enfermeiros.add(enfermeiro);
            }
            //retorna a lista de pessoas
            return (enfermeiros);
        } catch (SQLException e) {//tratamento de exceções
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();//fecha o banco de dados
        }
    }
    //insere um enfermeiro no banco
    public void insert(Enfermeiro enfermeiro) {
        String sqlQuery = "INSERT INTO ENFERMEIRO(CODPESSOA, COREN) "
                + "VALUES(" + enfermeiro.getCodPessoa() + ", "
                + Lib.quotedStr(enfermeiro.getCoren()) + ");";

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
    //atualiza um enfermeiro no banco
    public void update(Enfermeiro enfermeiro) {
        String sqlQuery = "UPDATE ENFERMEIRO "
                + "SET CODPESSOA = " + enfermeiro.getCodPessoa() + ", "
                + " COREN = " + Lib.quotedStr(enfermeiro.getCoren()) + " "
                + "WHERE CODPESSOA = " + enfermeiro.getCodPessoa();

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
    //deleta um enfermeiro no banco
    public void delete(int codPessoa) {
        String sqlQuery = "DELETE FROM ENFERMEIRO "
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
    //recebe um enfermeiro com codigo especificado
    public Enfermeiro getEnfermeiro(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM ENFERMEIRO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.connect(Dao.url);
        List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
        ResultSet resultSet;
        try {
            resultSet = this.getStatement().executeQuery(sqlQuery);
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
    //recebe um enfermeiro de acordo com seu coren  
    public Enfermeiro getEnfermeiro(String coren) {
        String sqlQuery = "SELECT * "
                + " FROM ENFERMEIRO "
                + " WHERE COREN LIKE " + Lib.quotedStr(coren);

        this.connect(Dao.url);
        List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
        ResultSet resultSet;
        try {
            resultSet = this.getStatement().executeQuery(sqlQuery);
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
    //encontra um enfermeiro usando o coren
    public boolean findEnfermeiro(String coren) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM ENFERMEIRO "
                    + " WHERE COREN LIKE " + Lib.quotedStr(coren);
            ResultSet resultSet = this.getStatement().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica a existencia de um enfermeiro
    public boolean existsEnfermeiro(int codPessoa) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM ENFERMEIRO "
                    + " WHERE CODPESSOA = " + codPessoa + ";";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica a existencia de um enfermeiro
    public boolean existsEnfermeiro(String coren) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM ENFERMEIRO "
                    + " WHERE COREN LIKE " + Lib.quotedStr(coren) + ";";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica se está em atendimento
    public boolean hasDependenceAtendimento(String coren) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT A.* "
                    + " FROM ATENDIMENTO A "
                    + " WHERE A.COREN LIKE " + Lib.quotedStr(coren) + ";";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //verifica se é usuário do sistema
    public boolean hasDependenceUsuario(String coren) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT U.* "
                    + " FROM USUARIO U "
                    + " WHERE U.CODPESSOA = (SELECT E.CODPESSOA"
                    + " FROM ENFERMEIRO E "
                    + " WHERE E.COREN LIKE " + Lib.quotedStr(coren) + ");";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    //pega colunas
    public String[] getColumns() {
        String[] aux = {"Código", "Nome", "CPF", "COREN", "Sexo"};
        return (aux);
    }
    //pega modelo de tabela
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
    //relatório
    public JasperViewer getIReport() {
        this.connect(url);
        try {
            this.getStatement().execute("SELECT E.*, P.*, "
                    + "             CASE P.SEXO "
                    + "                WHEN 'M' THEN 'Masculino' "
                    + "                WHEN 'F' THEN 'Feminino' "
                    + "             END AS PSEXO "
                    + "FROM ENFERMEIRO E "
                    + "JOIN PESSOA P ON P.CODPESSOA = E.CODPESSOA");
            JRResultSetDataSource relResult = new JRResultSetDataSource(this.getStatement().getResultSet());
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/Enfermeiro.jasper", new HashMap(), relResult);
            return (new JasperViewer(jpPrint, true));
        } catch (SQLException | JRException ex) {
            DExcecao excecao = new DExcecao(null, true, ex.getMessage());
            excecao.setVisible(true);
        }
        return (null);
    }
}
