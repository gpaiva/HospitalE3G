package br.com.hospitale3g.controller;

import br.com.hospitale3g.dao.Dao;
import br.com.hospitale3g.view.FLogin;

public class HospitalE3G {

    public static void main(String[] args) {
        Dao dao = new Dao();
        if (!dao.existsDataBase())
            dao.createDataBase();

        FLogin login = new FLogin();
        login.setVisible(true);
    }
}
