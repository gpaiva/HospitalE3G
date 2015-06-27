package br.com.hospitale3g.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.view.DExcecao;

public class Dao {

    static final String dataBase = "hospitale3g";
    static final String driver = "com.mysql.jdbc.Driver";
    static final String urlWithoutDB = "jdbc:mysql://localhost/";
    static final String url = "jdbc:mysql://localhost:3306/" + dataBase;
    static final String user = "root";
    static final String password = "";

    private Connection connection;
    private Statement statement;

    public void connect(String url) {//função para conectar com o banco de dados
        try {
            Class.forName(driver);//carrega o driver mysql
            this.setConnection(DriverManager.getConnection(url, user, password));//estabelece a conexão
            this.setStatement(this.getConnection().createStatement());//instanciando o statement
        } catch (ClassNotFoundException | SQLException e) {//caso tenha alguma exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);//é mostrado o frame de exceção ao usuario
        }
    }

    public void close() {
        try {
            this.getStatement().close();//fecha o statement
            this.getConnection().close();//fecha a conexao
        } catch (NullPointerException | SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);//é mostrado o frame de exceção ao usuario
        }
    }

    public Connection getConnection() {
        return (this.connection);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return (this.statement);
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public boolean existsDataBase() {
        try {
            Class.forName(driver);//carrega o driver mysql
            this.setConnection(DriverManager.getConnection(url, user, password));//estabelece a conexão
            this.setStatement(this.getConnection().createStatement());//instanciando o statement
        } catch (ClassNotFoundException | SQLException e) {
            return (false);//caso houver alguma exceção, o banco de dados não existe
        }
        return (true);//caso chegar aqui, ocorreu tudo certo, entao o banco de dados existe
    }

    public boolean createDataBase() {
        try {
            String scriptDataBase = "CREATE DATABASE " + dataBase;//script para criação de banco
            String scriptPessoa = "CREATE TABLE PESSOA("
                    + " CODPESSOA INTEGER, "
                    + " NOME VARCHAR(50) NOT NULL, "
                    + " CPF VARCHAR(15) NOT NULL, "
                    + " RG VARCHAR(15) NOT NULL, "
                    + " SEXO VARCHAR(15) NOT NULL, "
                    + " RUA VARCHAR(30) NOT NULL, "
                    + " NUMERO VARCHAR(10) NOT NULL, "
                    + " COMPLEMENTO VARCHAR(30), "
                    + " BAIRRO VARCHAR(30) NOT NULL, "
                    + " CIDADE VARCHAR(30) NOT NULL, "
                    + " CEP VARCHAR(15) NOT NULL, "
                    + " PRIMARY KEY (CODPESSOA));";
            String scriptAdministrador = "create table administrador("
                    + "admReg integer not null, "
                    + "codPessoa integer not null, "
                    + "primary key (admReg), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));";
            String scriptEnfermeiro = "create table enfermeiro("
                    + "coren varchar (15) not null, "
                    + "codPessoa integer not null, "
                    + "primary key (coren), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));";
            String scriptMedico = "create table medico("
                    + "crm varchar(15) not null, "
                    + "codPessoa integer not null, "
                    + "primary key (crm), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));";
            String scriptPaciente = "create table paciente("
                    + "id integer not null, "
                    + "codPessoa integer not null, "
                    + "primary key (id), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));";
            String scriptSecretario = "create table secretario("
                    + "registro integer not null, "
                    + "codPessoa integer not null, "
                    + "primary key (registro), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));";
            String scriptUsuario = "create table usuario("
                    + "codPessoa integer not null, "
                    + "usuLogin varchar(20) not null, "
                    + "usuSenha varchar(20) not null, "
                    + "primary key(codPessoa), "
                    + "foreign key(codPessoa) references pessoa(codPessoa));";
            String scriptAtendimento = "CREATE TABLE ATENDIMENTO("
                    + "ATENCODIGO INTEGER PRIMARY KEY, "
                    + "CRM VARCHAR(15) NOT NULL, "
                    + "ID INTEGER NOT NULL, "
                    + "COREN VARCHAR(15), "
                    + "ATENDATAHORA TIMESTAMP NOT NULL, "
                    + "ATENDATAHORAFINALIZADO TIMESTAMP, "
                    + "ATENSITUACAO INTEGER NOT NULL, "
                    + "ATENOBSERVACAO VARCHAR(500), "
                    + "FOREIGN KEY(CRM) REFERENCES MEDICO(CRM),"
                    + "FOREIGN KEY(ID) REFERENCES PACIENTE(ID), "
                    + "FOREIGN KEY(COREN) REFERENCES ENFERMEIRO(COREN));";
            String scriptInsertPessoa = "insert into pessoa(codPessoa, nome, sexo, cpf, rg,"
                    + "rua, numero, complemento, bairro, cidade, cep) "
                    + "values(1, "
                    + Lib.quotedStr("Administrador") + ","
                    + Lib.quotedStr('M') + ", "
                    + Lib.quotedStr("111.111.111-11") + ", "
                    + Lib.quotedStr("11.111.111") + ", "
                    + Lib.quotedStr("Rua") + ", "
                    + Lib.quotedStr("Número") + ", "
                    + Lib.quotedStr("Complemento") + ", "
                    + Lib.quotedStr("Bairro") + ", "
                    + Lib.quotedStr("Cidade") + ", "
                    + Lib.quotedStr("CEP") + ");";
            String scriptInsertUsuario = "insert into usuario(codPessoa, usuLogin, usuSenha) "
                    + "values(1, "
                    + Lib.quotedStr("admin") + ","
                    + Lib.quotedStr("admin") + ");";

            Class.forName(driver);//carrega o driver mysql
            this.setConnection(DriverManager.getConnection(urlWithoutDB, user, password));//estabelece a conexao somente com o mysql
            this.setStatement(this.getConnection().createStatement());//instanciando o statement
            this.getStatement().executeUpdate(scriptDataBase);//executa script
            this.getStatement().close();//fecha o statement
            this.getConnection().close();//fecha a conexão
            this.connect(url);//conecta com o banco de dados
            this.getConnection().setAutoCommit(false);//altera o auto commit para false

            //executa scripts para criação de tabelas e registros padrões do banco de dados
            this.executeScript(scriptPessoa);
            this.executeScript(scriptAdministrador);
            this.executeScript(scriptEnfermeiro);
            this.executeScript(scriptMedico);
            this.executeScript(scriptPaciente);
            this.executeScript(scriptSecretario);
            this.executeScript(scriptUsuario);
            this.executeScript(scriptAtendimento);
            this.executeScript(scriptInsertPessoa);
            this.executeScript(scriptInsertUsuario);
        } catch (ClassNotFoundException | SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);//caso houver exceção, é mostrado a tela da mesma
            return (false);//retorna false, houve um erro ao criar o banco de dados
        }
        return (true);//retorna true, nao houve nenhum erro
    }

    public void executeScript(String script) throws SQLException {
        this.getStatement().executeUpdate(script);//execute o script passado por parametro
        this.getConnection().commit();//commita a alteração feita no banco de dados
    }
}
