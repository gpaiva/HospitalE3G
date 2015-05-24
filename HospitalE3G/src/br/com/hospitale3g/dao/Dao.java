package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.hospitale3g.view.DExcecao;

public class Dao {
    static final String dataBase = "hospitale3g";
    static final String driver = "com.mysql.jdbc.Driver";
    static final String urlWithoutDB = "jdbc:mysql://localhost/";
    static final String url = "jdbc:mysql://localhost:3306/" + dataBase;
    static final String user = "root";
    static final String password = "";

    private Connection con;
    private Statement comando;

    public void conect(String url) {
        try {
            Class.forName(driver);
            this.setCon(DriverManager.getConnection(url, user, password));
            this.setComando(con.createStatement());
        } catch (ClassNotFoundException | SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        }
    }

    public void close() {
        try {
            this.getComando().close();
            this.getCon().close();
        } catch (NullPointerException | SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
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

    public boolean existsDataBase() {
        try {
            Class.forName(driver);
            this.setCon(DriverManager.getConnection(url, user, password));
            this.setComando(con.createStatement());
        } catch (ClassNotFoundException | SQLException e) {
            return (false);
        }
        return (true);
    }

    public boolean createDataBase() {

        try {
            Class.forName(driver);
            this.setCon(DriverManager.getConnection(urlWithoutDB, user, password));
            this.setComando(con.createStatement());
            this.getComando().executeUpdate("create database " + dataBase);
            this.getComando().close();
            this.getCon().close();
            this.conect(url);
            this.getCon().setAutoCommit(false);
            this.getComando().executeUpdate("create table pessoa("
                    + "codPessoa integer auto_increment, "
                    + "nome varchar(50) not null, "
                    + "cpf varchar(15) not null, "
                    + "rg varchar(15) not null, "
                    + "sexo varchar(15) not null, "
                    + "primary key (codPessoa));");
            this.getCon().commit();
            this.getComando().executeUpdate("create table administrador("
                    + "admReg integer not null, "
                    + "codPessoa integer not null, "
                    + "primary key (admReg), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));");
            this.getCon().commit();
            this.getComando().executeUpdate("create table enfermeiro("
                    + "coren varchar (15) not null, "
                    + "codPessoa integer not null, "
                    + "primary key (coren), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));");
            this.getCon().commit();
            this.getComando().executeUpdate("create table medico("
                    + "crm varchar(15) not null, "
                    + "codPessoa integer not null, "
                    + "primary key (crm), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));");
            this.getCon().commit();
            this.getComando().executeUpdate("create table paciente("
                    + "id integer not null, "
                    + "codPessoa integer not null, "
                    + "primary key (id), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));");
            this.getCon().commit();
            this.getComando().executeUpdate("create table secretario("
                    + "registro integer not null, "
                    + "codPessoa integer not null, "
                    + "primary key (registro), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));");
            this.getCon().commit();
            this.getComando().executeUpdate("create table usuario("
                    + "codPessoa integer not null, "
                    + "usuLogin varchar(20) not null, "
                    + "usuSenha varchar(20) not null, "
                    + "primary key(codPessoa), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));");
            this.getCon().commit();
            this.getComando().executeUpdate("insert into pessoa(codPessoa, nome, sexo, cpf, rg) "
                    + "values(1, "
                    + Lib.quotedStr("Administrador") + ","
                    + Lib.quotedStr('M') + ", "
                    + Lib.quotedStr("111.111.111-11") + ", "
                    + Lib.quotedStr("1111111111") + ");");
            this.getCon().commit();
            this.getComando().executeUpdate("insert into usuario(codPessoa, usuLogin, usuSenha) "
                    + "values(1, "
                    + Lib.quotedStr("admin") + ","
                    + Lib.quotedStr("admin") + ");");
            this.getCon().commit();
        } catch (ClassNotFoundException | SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (false);
        }
        return (true);

    }
}
