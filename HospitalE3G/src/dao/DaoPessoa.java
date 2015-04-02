package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.Pessoa;

public class DaoPessoa extends Dao {

    public List<Pessoa> select() {
        this.conectar();
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        ResultSet rs;
        try {
            rs = this.getComando().executeQuery("SELECT * "
                    + "FROM PESSOA");
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setPesCodigo(Integer.parseInt(rs.getString("PESCODIGO")));
                pessoa.setPesNome(rs.getString("PESNOME"));
                pessoas.add(pessoa);
            }
            return (pessoas);
        } catch (SQLException e) {
            System.err.println("Erro ao buscar pessoa");
            return (null);
        } finally {
            this.fechar();
        }
    }

    public void insert(Pessoa pessoa) {
        this.conectar();
        try {
            this.getComando().executeUpdate("INSERT INTO PESSOA(PESCODIGO, PESNOME) "
                    + "VALUES('" + pessoa.getPesCodigo() + "', '" + pessoa.getPesNome() + "')");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Pessoas");
        } finally {
            this.fechar();
        }
    }

    public void update(Pessoa pessoa) {
        this.conectar();
        try {
            this.getComando().executeUpdate("UPDATE PESSOA "
                    + "SET PESCODIGO = " + pessoa.getPesCodigo() + ", "
                    + " PESNOME = '" + pessoa.getPesNome() + "' "
                    + "WHERE PESCODIGO = " + pessoa.getPesCodigo());
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Pessoas");
        } finally {
            this.fechar();
        }
    }

    public void delete(int pesCodigo) {
        this.conectar();
        try {
            this.getComando().executeUpdate("DELETE FROM PESSOA "
                    + " WHERE PESCODIGO = " + pesCodigo);
        } catch (SQLException e) {
            System.err.println("Erro ao apagar Pessoas");
        } finally {
            this.fechar();
        }
    }

    public int getNextCodigo() {
        int aux = -1;
        String sqlQuery = "SELECT MAX(PESCODIGO) + 1 AS PESCODIGO "
                + " FROM PESSOA ";
        this.conectar();
        try {
            ResultSet rs = this.getComando().executeQuery(sqlQuery);
            while (rs.next()) {
                aux = rs.getInt("PESCODIGO");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar próximo Código!");
        } finally {
            this.fechar();
        }
        return (aux);
    }

    public String[] getColumns() {
        String[] aux = {"Código", "Nome"};
        return (aux);
    }
}
