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
    //constantes com os nomes de cada atributo no banco de dados
    static final String codPessoa = "codPessoa";
    static final String usuLogin = "usuLogin";
    static final String usuSenha = "usuSenha";
    //função que retorna em uma lista, os dados que estão no banco de dados
    public List<Usuario> select() {
        String sqlQuery = "SELECT * "
                + "FROM USUARIO";
        //conecta no banco de dados
        this.connect(Dao.url);
        //instancia uma lista de usuarios
        List<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet rs1;
        try {
            //recebe os dados retornados da query
            rs1 = this.getStatement().executeQuery(sqlQuery);
            //caso ainda houver proximo no rs1
            while (rs1.next()) {
                //é criado uma nova instancia de pessoa de acordo com os dados
                //do rs1
                int codPessoa = rs1.getInt(UsuarioDao.codPessoa);

                PessoaDao daoPessoa = new PessoaDao();
                Pessoa pessoa = daoPessoa.getPessoa(codPessoa);

                Usuario usuario = new Usuario(pessoa,
                        rs1.getString(UsuarioDao.usuLogin),
                        rs1.getString(UsuarioDao.usuSenha));
                //adiciona o usuario na lista de usuarios
                usuarios.add(usuario);
            }
            //retorna a lista de usuarios
            return (usuarios);
        } catch (SQLException e) {//tratamento de exceções
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {//fecha o banco de dados
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
    //função que atualiza um usuario no banco de dados
    public void update(Usuario usuario) {
        String sqlQuery = "UPDATE USUARIO "
                + "SET CODPESSOA = " + usuario.getCodPessoa() + ", "
                + " USULOGIN = " + Lib.quotedStr(usuario.getUsuLogin()) + ", "
                + " USUSENHA = " + Lib.quotedStr(usuario.getUsuSenha()) + " "
                + "WHERE CODPESSOA = " + usuario.getCodPessoa();

        //conecta com o banco de dados
        this.connect(Dao.url);
        try {
            //executa a query
            this.getStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {//tratamento de exceção
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {//fecha a conexão
            this.close();
        }
    }

    //função que delete uma pessoa de acordo com o código passado por parametro
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

    //função que retorna o proximo código da pessoa
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
    //função que retorna um usuario de acordo com o login e senha passado como parametro
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
    //atribui o privilegio ao usuario
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
    //encontra o usuario com login e senha passados no parametro
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
    //
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
