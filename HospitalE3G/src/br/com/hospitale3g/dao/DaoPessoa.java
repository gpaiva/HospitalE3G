package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.view.DExcecao;
import javax.swing.table.DefaultTableModel;

public class DaoPessoa extends Dao {

    static final String codPessoa = "codPessoa";
    static final String nome = "nome";
    static final String cpf = "cpf";
    static final String rg = "rg";
    static final String sexo = "sexo";

    public List<Pessoa> select() {
        String sqlQuery = "SELECT * "
                + "FROM PESSOA";

        this.conect(Dao.url);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        ResultSet rs;
        try {
            rs = this.getComando().executeQuery(sqlQuery);
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(rs.getInt(codPessoa),
                        rs.getString(nome),
                        rs.getString(sexo).charAt(0),
                        rs.getString(cpf),
                        rs.getString(rg));
                pessoas.add(pessoa);
            }
            return (pessoas);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    public void insert(Pessoa pessoa) {
        String sqlQuery = "INSERT INTO PESSOA(CODPESSOA, NOME, CPF, RG, SEXO) "
                + "VALUES(" + pessoa.getCodPessoa() + ", "
                + Lib.quotedStr(pessoa.getNome()) + ", "
                + Lib.quotedStr(pessoa.getCpf()) + ", "
                + Lib.quotedStr(pessoa.getRg()) + ", "
                + Lib.quotedStr(pessoa.getSexo()) + ");";

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

    public void update(Pessoa pessoa) {
        String sqlQuery = "UPDATE PESSOA "
                + "SET CODPESSOA = " + pessoa.getCodPessoa() + ", "
                + " NOME = " + Lib.quotedStr(pessoa.getNome()) + ", "
                + " CPF = " + Lib.quotedStr(pessoa.getCpf()) + ", "
                + " RG = " + Lib.quotedStr(pessoa.getRg()) + ", "
                + " SEXO = " + Lib.quotedStr(pessoa.getSexo()) + " "
                + "WHERE CODPESSOA = " + pessoa.getCodPessoa();

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
        String sqlQuery = "DELETE FROM PESSOA "
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

    public int getNextCodPessoa() {
        int aux = -1;
        String sqlQuery = "SELECT MAX(CODPESSOA) + 1 AS CODPESSOA "
                + " FROM PESSOA ";

        this.conect(Dao.url);
        try {
            ResultSet rs = this.getComando().executeQuery(sqlQuery);
            while (rs.next()) {
                aux = rs.getInt("CODPESSOA");
            }
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
        return (aux);
    }

    public Pessoa getPessoa(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM PESSOA "
                + " WHERE CODPESSOA = " + codPessoa;

        this.conect(Dao.url);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        ResultSet rs;
        try {
            rs = this.getComando().executeQuery(sqlQuery);

            if ((rs != null) && (rs.next())) {
                Pessoa pessoa = new Pessoa(rs.getInt(DaoPessoa.codPessoa),
                        rs.getString(DaoPessoa.nome),
                        rs.getString(DaoPessoa.sexo).charAt(0),
                        rs.getString(DaoPessoa.cpf),
                        rs.getString(DaoPessoa.rg));
                return (pessoa);
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

    public String[] getColumns() {
        String[] aux = {"Código", "Nome", "Sexo", "CPF", "RG"};
        return (aux);
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };
        
        for (int i = 0; i <= this.getColumns().length - 1; i++) {
            String[] aux = this.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Pessoa pessoa : this.select()) {
            model.addRow(new Object[]{pessoa.getCodPessoa(), pessoa.getNome(),
                Lib.iif(pessoa.getSexo() == 'M', "Masculino", "Feminino"),
                pessoa.getCpf(), pessoa.getRg()});
        }
        return (model);
    }
}
