package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/hospital";
    private final String nome = "root";
    private final String senha = "admin";
    private Connection con;
    private Statement comando;

    protected void conectar() {
        try {
            Class.forName(driver);
            this.setCon(DriverManager.getConnection(url, nome, senha));
            this.setComando(con.createStatement());
            System.out.println("Conectado!");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar o driver");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar");
        }
    }

    protected void fechar() {
        try {
            this.getComando().close();
            this.getCon().close();
            System.out.println("Conexão Fechada");
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão");
        }
    }

    public Connection getCon() {
        return (this.con);
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getComando() {
        return (this.comando);
    }

    public void setComando(Statement comando) {
        this.comando = comando;
    }
}
