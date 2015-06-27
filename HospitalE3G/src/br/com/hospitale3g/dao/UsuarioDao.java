package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.EnfermeiroController;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.MedicoController;
import br.com.hospitale3g.controller.PacienteController;
import br.com.hospitale3g.controller.SecretarioController;
import static br.com.hospitale3g.dao.Dao.url;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Usuario;
import br.com.hospitale3g.model.Enfermeiro;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.model.Paciente;
import br.com.hospitale3g.model.Secretario;
import br.com.hospitale3g.view.DExcecao;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class UsuarioDao extends Dao {

    static final String codPessoa = "codPessoa";
    static final String usuLogin = "usuLogin";
    static final String usuSenha = "usuSenha";

    public List<Usuario> select() {
        String sqlQuery = "SELECT * "
                + "FROM USUARIO";

        this.connect(Dao.url);
        List<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet rs1;
        try {
            rs1 = this.getStatement().executeQuery(sqlQuery);
            while (rs1.next()) {
                int codPessoa = rs1.getInt(UsuarioDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Usuario usuario = new Usuario(pessoa,
                        rs1.getString(UsuarioDao.usuLogin),
                        rs1.getString(UsuarioDao.usuSenha));
                usuarios.add(usuario);
            }
            return (usuarios);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    public void insert(Usuario usuario) {
        String sqlQuery = "INSERT INTO USUARIO(CODPESSOA, USULOGIN, USUSENHA) "
                + "VALUES(" + usuario.getCodPessoa() + ", "
                + Lib.quotedStr(usuario.getUsuLogin()) + ", "
                + Lib.quotedStr(usuario.getUsuSenha()) + ");";

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

    public void update(Usuario usuario) {
        String sqlQuery = "UPDATE USUARIO "
                + "SET CODPESSOA = " + usuario.getCodPessoa() + ", "
                + " USULOGIN = " + Lib.quotedStr(usuario.getUsuLogin()) + ", "
                + " USUSENHA = " + Lib.quotedStr(usuario.getUsuSenha()) + " "
                + "WHERE CODPESSOA = " + usuario.getCodPessoa();

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

    public void delete(int codPessoa) {
        String sqlQuery = "DELETE FROM USUARIO "
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

    public Usuario getUsuario(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM USUARIO "
                + " WHERE CODPESSOA = " + codPessoa;

        this.connect(Dao.url);
        List<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet rs;
        try {
            rs = this.getStatement().executeQuery(sqlQuery);
            if ((rs != null) && (rs.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(rs.getInt(UsuarioDao.codPessoa));

                Usuario usuario = new Usuario(pessoa,
                        rs.getString(UsuarioDao.usuLogin),
                        rs.getString(UsuarioDao.usuSenha));
                return (usuario);
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

    public Usuario getUsuario(String usuLogin, String usuSenha) {
        String sqlQuery = "SELECT * "
                + " FROM USUARIO "
                + " WHERE USULOGIN LIKE " + Lib.quotedStr(usuLogin) + " AND "
                + "       USUSENHA LIKE " + Lib.quotedStr(usuSenha) + ";";

        this.connect(Dao.url);
        List<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet rs;
        try {
            rs = this.getStatement().executeQuery(sqlQuery);
            if ((rs != null) && (rs.next())) {
                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(rs.getInt(UsuarioDao.codPessoa));

                Usuario usuario = new Usuario(pessoa,
                        rs.getString(UsuarioDao.usuLogin),
                        rs.getString(UsuarioDao.usuSenha));
                return (usuario);
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

    public String getPrivilegio(Usuario usuario) {
        if (usuario.getCodPessoa() == 1) {
            return ("Administrador");
        }
        Enfermeiro enfermeiro = EnfermeiroController.getEnfermeiro(usuario.getCodPessoa());
        if (enfermeiro != null) {
            return ("Enfermeiro");
        }
        Medico medico = MedicoController.getMedico(usuario.getCodPessoa());
        if (medico != null) {
            return ("Médico");
        }
        Paciente paciente = PacienteController.getPaciente(usuario.getCodPessoa());
        if (paciente != null) {
            return ("Paciente");
        }
        Secretario secretario = SecretarioController.getSecretario(usuario.getCodPessoa());
        if (secretario != null) {
            return ("Secretário");
        }
        return ("Desconhecido");
    }

    public boolean findUsuario(String usuLogin, String usuSenha) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM USUARIO "
                    + " WHERE USULOGIN LIKE '" + usuLogin + "' AND "
                    + " USUSENHA LIKE '" + usuSenha + "'";
            ResultSet result = this.getStatement().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }

    public boolean existsUsuarioCodPessoa(int codPessoa) {
        this.connect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM USUARIO "
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

    public String[] getColumns() {
        String[] aux = {"Código", "Nome", "Login", "Sexo"};
        return (aux);
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };
        UsuarioDao daoUsuario = new UsuarioDao();
        for (int i = 0; i <= daoUsuario.getColumns().length - 1; i++) {
            String[] aux = daoUsuario.getColumns();
            model.addColumn(aux[i]);
        }
        model.setNumRows(0);
        for (Usuario usuario : this.select()) {
            model.addRow(new Object[]{usuario.getCodPessoa(),
                usuario.getNome(),
                usuario.getUsuLogin(),
                Lib.iif(usuario.getSexo() == 'M', "Masculino", "Feminino")});
        }
        return (model);
    }

    public JasperViewer getIReport() {
        this.connect(url);
        try {
            this.getStatement().execute("SELECT U.CODPESSOA, U.USULOGIN, "
                    + "       (SELECT P.NOME "
                    + "        FROM PESSOA P "
                    + "        WHERE P.CODPESSOA = U.CODPESSOA) AS NOME "
                    + "FROM USUARIO U");
            JRResultSetDataSource relResult = new JRResultSetDataSource(this.getStatement().getResultSet());
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/Usuario.jasper", new HashMap(), relResult);
            return (new JasperViewer(jpPrint, true));
        } catch (SQLException | JRException ex) {
            DExcecao excecao = new DExcecao(null, true, ex.getMessage());
            excecao.setVisible(true);
        }
        return (null);
    }
}
