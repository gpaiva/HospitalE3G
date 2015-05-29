package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.view.DExcecao;

public class MedicoDao extends Dao {

    static final String codPessoa = "codPessoa";
    static final String crm = "crm";

    public List<Medico> select() {
        String sqlQuery = "SELECT * "
                + "FROM MEDICO";

        this.conect(Dao.url);
        List<Medico> medicos = new ArrayList<Medico>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            while (resultSet.next()) {
                int codPessoa = resultSet.getInt(MedicoDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Medico medico = new Medico(pessoa,
                        resultSet.getString(MedicoDao.crm));
                medicos.add(medico);
            }
            return (medicos);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    public void insert(Medico medico) {
        String sqlQuery = "INSERT INTO MEDICO(CODPESSOA, CRM) "
                + "VALUES(" + medico.getCodPessoa() + ", "
                + Lib.quotedStr(medico.getCrm()) + ");";

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

    public void update(Medico medico) {
        String sqlQuery = "UPDATE MEDICO "
                + "SET CODPESSOA = " + medico.getCodPessoa() + ", "
                + " CRM = " + Lib.quotedStr(medico.getCrm()) + " "
                + "WHERE CODPESSOA = " + medico.getCodPessoa();

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
        String sqlQuery = "DELETE FROM MEDICO "
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

    public Medico getMedico(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM MEDICO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.conect(Dao.url);
        List<Medico> medicos = new ArrayList<Medico>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(resultSet.getInt(MedicoDao.codPessoa));

                Medico medico = new Medico(pessoa,
                        resultSet.getString(MedicoDao.crm));
                return (medico);
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

    public boolean findMedico(String crm) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM MEDICO "
                    + " WHERE CRM LIKE " + Lib.quotedStr(crm);
            ResultSet resultSet = this.getComando().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }

    public String[] getColumns() {
        String[] aux = {"Código", "CRM"};
        return (aux);
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };
        
        MedicoDao medicoDao = new MedicoDao();
        for (int i = 0; i <= medicoDao.getColumns().length - 1; i++) {
            String[] aux = medicoDao.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Medico medico : this.select()) {
            model.addRow(new Object[]{medico.getCodPessoa(), medico.getCrm()});
        }
        return (model);
    }
}