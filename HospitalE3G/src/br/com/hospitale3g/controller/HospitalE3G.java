package br.com.hospitale3g.controller;

import br.com.hospitale3g.dao.Dao;
import br.com.hospitale3g.view.DExcecao;
import br.com.hospitale3g.view.FLogin;

public class HospitalE3G {

    public static void main(String[] args) {
        Dao dao = new Dao();//cria uma nova instancia de Dao
        if (!dao.existsDataBase())//função que verifica se existe o banco de dados
        {
            if (!dao.createDataBase()) {//cria banco de dados
                DExcecao excecao = new DExcecao(null, true, "Ocorreu uma exceção!\n"
                        + "Banco de Dados não foi criado corretamente!");
            }
        }

        FLogin login = new FLogin();//cria uma nova instancia de login
        login.setVisible(true);//altera a visibilidade do frame para verdadeiro
    }
}
