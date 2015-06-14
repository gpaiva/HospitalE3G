package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.Lib;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.model.Paciente;
import br.com.hospitale3g.model.Enfermeiro;
import br.com.hospitale3g.model.Atendimento;
import br.com.hospitale3g.view.DExcecao;
import java.text.SimpleDateFormat;

public class AtendimentoDao extends Dao {

    static final String atencodigo = "atencodigo";
    static final String crm = "crm";
    static final String id = "id";
    static final String coren = "coren";
    static final String atendatahora = "atendatahora";
    static final String atendatahorafinalizado = "atendatahorafinalizado";
    static final String atensituacao = "atensituacao";

    public List<Atendimento> select() {
        String sqlQuery = "SELECT * "
                + "FROM ATENDIMENTO";

        this.conect(Dao.url);
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            while (resultSet.next()) {
                Atendimento atendimento = new Atendimento(
                        resultSet.getInt(AtendimentoDao.atencodigo),
                        resultSet.getString(AtendimentoDao.crm),
                        resultSet.getInt(AtendimentoDao.id),
                        resultSet.getString(AtendimentoDao.coren),
                        resultSet.getTimestamp(AtendimentoDao.atendatahora),
                        resultSet.getTimestamp(AtendimentoDao.atendatahorafinalizado),
                        resultSet.getInt(AtendimentoDao.atensituacao));
                atendimentos.add(atendimento);
            }
            return (atendimentos);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    public void insert(Atendimento atendimento) {
        String sqlQuery = "INSERT INTO ATENDIMENTO(ATENCODIGO, CRM, ID, "
                + "ATENDATAHORA, ATENSITUACAO)"
                + "VALUES(" + atendimento.getAtenCodigo() + ", "
                + Lib.quotedStr(atendimento.getCrm()) + ", "
                + atendimento.getId() + ", "
                + Lib.quotedStr(new SimpleDateFormat("yyyy.MM.dd hh:mm").format(atendimento.getAtenDataHora())) + ", "
                + atendimento.getAtenSituacao() + ");";

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

    public void update(Atendimento atendimento) {
        String sqlQuery = "UPDATE ATENDIMENTO "
                + "SET ATENCODIGO = " + atendimento.getAtenCodigo() + ", "
                + " CRM = " + Lib.quotedStr(atendimento.getCrm()) + ", "
                + " ID = " + atendimento.getId() + ", "
                + " ATENDATAHORA = " + Lib.quotedStr(new SimpleDateFormat("yyyy.MM.dd hh:mm").format(atendimento.getAtenDataHora())) + ", "
                + " ATENSITUACAO = " + atendimento.getAtenSituacao() + " "
                + "WHERE ATENCODIGO = " + atendimento.getAtenCodigo() + ";";
        String sqlQueryCoren = "";
        if (atendimento.getCoren() != null) {
            sqlQueryCoren = "UPDATE ATENDIMENTO "
                    + "SET COREN = " + Lib.quotedStr(atendimento.getCoren())
                    + "WHERE ATENCODIGO = " + atendimento.getAtenCodigo() + ";";
        }
        String sqlQueryFinalizado = "";
        if (atendimento.getAtenDataHoraFinalizado() != null) {
            sqlQueryFinalizado = "UPDATE ATENDIMENTO "
                    + "SET ATENDATAHORAFINALIZADO = " + Lib.quotedStr(new SimpleDateFormat("yyyy.MM.dd hh:mm").format(atendimento.getAtenDataHoraFinalizado()))
                    + "WHERE ATENCODIGO = " + atendimento.getAtenCodigo() + ";";
        }
        this.conect(Dao.url);
        try {
            this.getComando().executeUpdate(sqlQuery);
            if (!sqlQueryCoren.isEmpty()) {
                this.getComando().executeUpdate(sqlQueryCoren);
            }
            if (!sqlQueryFinalizado.isEmpty()) {
                this.getComando().executeUpdate(sqlQueryFinalizado);
            }
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
    }

    public void delete(int atenCodigo) {
        String sqlQuery = "UPDATE ATENDIMENTO "
                + " SET ATENSITUACAO = 1 "
                + "WHERE ATENCODIGO = " + atenCodigo;

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

    public Atendimento getAtendimento(int atenCodigo) {
        String sqlQuery = "SELECT * "
                + " FROM ATENDIMENTO "
                + " WHERE ATENCODIGO = " + atenCodigo;

        this.conect(Dao.url);
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();
        ResultSet resultSet;
        try {
            resultSet = this.getComando().executeQuery(sqlQuery);
            if ((resultSet != null) && (resultSet.next())) {
                Atendimento atendimento = new Atendimento(
                        resultSet.getInt(AtendimentoDao.atencodigo),
                        resultSet.getString(AtendimentoDao.crm),
                        resultSet.getInt(AtendimentoDao.id),
                        resultSet.getString(AtendimentoDao.coren),
                        resultSet.getTimestamp(AtendimentoDao.atendatahora),
                        resultSet.getTimestamp(AtendimentoDao.atendatahorafinalizado),
                        resultSet.getInt(AtendimentoDao.atensituacao));
                return (atendimento);
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

    public boolean findAtendimento(int atenCodigo) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM ATENDIMENTO "
                    + " WHERE ATENCODIGO LIKE " + atenCodigo;
            ResultSet resultSet = this.getComando().executeQuery(sqlQuery);
            return (resultSet.first());
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
        return (false);
    }

    public int getNextAtenCodigo() {
        int aux = -1;
        String sqlQuery = "SELECT COALESCE(MAX(ATENCODIGO), 0) + 1 AS ATENCODIGO "
                + " FROM ATENDIMENTO ";

        this.conect(Dao.url);
        try {
            ResultSet rs = this.getComando().executeQuery(sqlQuery);
            while (rs.next()) {
                aux = rs.getInt("ATENCODIGO");
            }
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
        return (aux);
    }

    public String[] getColumns() {
        String[] aux = {"Código", "Médico", "Código Médico", "Paciente", "Código Paciente",
            "Situação", "Enfermeiro", "Código Enfermeiro", "Data", "Hora"/*,"Data Finalização",
         "Hora Finalização"*/

        };
        return (aux);
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };

        AtendimentoDao atendimentoDao = new AtendimentoDao();
        for (int i = 0; i <= atendimentoDao.getColumns().length - 1; i++) {
            String[] aux = atendimentoDao.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Atendimento atendimento : this.select()) {
            MedicoDao medicoDao = new MedicoDao();
            Medico medico = medicoDao.getMedico(atendimento.getCrm());
            PacienteDao pacienteDao = new PacienteDao();
            Paciente paciente = pacienteDao.getPacienteId(atendimento.getId());
            String enfermeiroNome = "";
            String enfermeiroCodPessoa = "";
            if (atendimento.getCoren() != null) {
                EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
                Enfermeiro enfermeiro = enfermeiroDao.getEnfermeiro(atendimento.getCoren());
                enfermeiroNome = enfermeiro.getNome();
                enfermeiroCodPessoa = Integer.toString(enfermeiro.getCodPessoa());
            }

            String situacao;
            switch (atendimento.getAtenSituacao()) {
                case 0:
                    situacao = "Aberto";
                    break;
                case 1:
                    situacao = "Cancelado";
                    break;
                case 2:
                    situacao = "Finalizado";
                    break;
                default:
                    situacao = "Desconhecido";
                    break;
            }

            model.addRow(new Object[]{atendimento.getAtenCodigo(),
                medico.getNome(),
                medico.getCodPessoa(),
                paciente.getNome(),
                paciente.getCodPessoa(),
                situacao,
                enfermeiroNome,
                enfermeiroCodPessoa,
                atendimento.getAtenDataHora().toString(),
                atendimento.getAtenDataHora().toString() /*atendimento.getAtenDataHoraFinalizado().toString(),
             atendimento.getAtenDataHoraFinalizado().toString(),*/});
        }
        return (model);
    }
}
