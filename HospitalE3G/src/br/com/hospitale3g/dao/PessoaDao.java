package br.com.hospitale3g.dao;

import br.com.hospitale3g.controller.EnfermeiroController;
import br.com.hospitale3g.controller.Lib;
import br.com.hospitale3g.controller.MedicoController;
import br.com.hospitale3g.controller.PacienteController;
import br.com.hospitale3g.controller.SecretarioController;
import br.com.hospitale3g.model.Enfermeiro;
import br.com.hospitale3g.model.Medico;
import br.com.hospitale3g.model.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import br.com.hospitale3g.model.Pessoa;
import br.com.hospitale3g.model.Secretario;
import br.com.hospitale3g.model.Usuario;
import br.com.hospitale3g.view.DExcecao;
import javax.swing.table.DefaultTableModel;

public class PessoaDao extends Dao {

    static final String codPessoa = "codPessoa";
    static final String nome = "nome";
    static final String cpf = "cpf";
    static final String rg = "rg";
    static final String sexo = "sexo";
    static final String rua = "rua";
    static final String numero = "numero";
    static final String complemento = "complemento";
    static final String bairro = "bairro";
    static final String cidade = "cidade";
    static final String cep = "cep";

    public PessoaDao() {
        super();
    }

    public List<Pessoa> select() {
        String sqlQuery = "SELECT * "
                + "FROM PESSOA";

        this.conect(Dao.url);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        ResultSet rs;
        try {
            rs = this.getComando().executeQuery(sqlQuery);
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(rs.getInt(codPessoa),
                        rs.getString(nome),
                        rs.getString(sexo).charAt(0),
                        rs.getString(cpf),
                        rs.getString(rg),
                        rs.getString(rua),
                        rs.getString(numero),
                        rs.getString(complemento),
                        rs.getString(bairro),
                        rs.getString(cidade),
                        rs.getString(cep));
                pessoas.add(pessoa);
            }
            return (pessoas);
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
            return (null);
        } finally {
            this.close();
        }
    }

    public void insert(Pessoa pessoa) {
        String sqlQuery = "INSERT INTO PESSOA(CODPESSOA, NOME, CPF, RG, SEXO, "
                + "RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, CEP) "
                + "VALUES(" + pessoa.getCodPessoa() + ", "
                + Lib.quotedStr(pessoa.getNome()) + ", "
                + Lib.quotedStr(pessoa.getCpf()) + ", "
                + Lib.quotedStr(pessoa.getRg()) + ", "
                + Lib.quotedStr(pessoa.getSexo()) + ", "
                + Lib.quotedStr(pessoa.getRua()) + ", "
                + Lib.quotedStr(pessoa.getNumero()) + ", "
                + Lib.quotedStr(pessoa.getComplemento()) + ", "
                + Lib.quotedStr(pessoa.getBairro()) + ", "
                + Lib.quotedStr(pessoa.getCidade()) + ", "
                + Lib.quotedStr(pessoa.getCep()) + ");";
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

    public void update(Pessoa pessoa) {
        String sqlQuery = "UPDATE PESSOA "
                + "SET CODPESSOA = " + pessoa.getCodPessoa() + ", "
                + " NOME = " + Lib.quotedStr(pessoa.getNome()) + ", "
                + " CPF = " + Lib.quotedStr(pessoa.getCpf()) + ", "
                + " RG = " + Lib.quotedStr(pessoa.getRg()) + ", "
                + " SEXO = " + Lib.quotedStr(pessoa.getSexo()) + ", "
                + " RUA = " + Lib.quotedStr(pessoa.getRua()) + ", "
                + " NUMERO = " + Lib.quotedStr(pessoa.getNumero()) + ", "
                + " COMPLEMENTO = " + Lib.quotedStr(pessoa.getComplemento()) + ", "
                + " BAIRRO = " + Lib.quotedStr(pessoa.getBairro()) + ", "
                + " CIDADE = " + Lib.quotedStr(pessoa.getCidade()) + ", "
                + " CEP = " + Lib.quotedStr(pessoa.getCep()) + " "
                + "WHERE CODPESSOA = " + pessoa.getCodPessoa();

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
        String sqlQuery = "DELETE FROM PESSOA "
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

    public int getNextCodPessoa() {
        int aux = -1;
        String sqlQuery = "SELECT COALESCE(MAX(CODPESSOA), 0) + 1 AS CODPESSOA "
                + " FROM PESSOA ";

        this.conect(Dao.url);
        try {
            ResultSet rs = this.getComando().executeQuery(sqlQuery);
            while (rs.next()) {
                aux = rs.getInt("CODPESSOA");
            }
        } catch (SQLException e) {
            DExcecao excecao = new DExcecao(null, true, e.getMessage());
            excecao.setVisible(true);
        } finally {
            this.close();
        }
        return (aux);
    }

    public Pessoa getPessoa(int codPessoa) {
        String sqlQuery = "SELECT * "
                + " FROM PESSOA "
                + " WHERE CODPESSOA = " + codPessoa;

        this.conect(Dao.url);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        ResultSet rs;
        try {
            rs = this.getComando().executeQuery(sqlQuery);

            if ((rs != null) && (rs.next())) {
                Pessoa pessoa = new Pessoa(rs.getInt(PessoaDao.codPessoa),
                        rs.getString(PessoaDao.nome),
                        rs.getString(PessoaDao.sexo).charAt(0),
                        rs.getString(PessoaDao.cpf),
                        rs.getString(PessoaDao.rg),
                        rs.getString(rua),
                        rs.getString(numero),
                        rs.getString(complemento),
                        rs.getString(bairro),
                        rs.getString(cidade),
                        rs.getString(cep));
                return (pessoa);
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

    public boolean existsPessoaCpf(String cpf) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM PESSOA "
                    + " WHERE CPF LIKE " + Lib.quotedStr(cpf) + ";";
            ResultSet result = this.getComando().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    
    public boolean existsPessoaRg(String rg) {
        this.conect(Dao.url);
        try {
            String sqlQuery = "SELECT * "
                    + " FROM PESSOA "
                    + " WHERE RG LIKE " + Lib.quotedStr(rg) + ";";
            ResultSet result = this.getComando().executeQuery(sqlQuery);
            return (result.first());
        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {
            this.close();
        }
        return (false);
    }
    
    public String getPessoa(Pessoa pessoa) {
        if (pessoa.getCodPessoa() == 1) {
            return ("Administrador");
        }
        Enfermeiro enfermeiro = EnfermeiroController.getEnfermeiro(pessoa.getCodPessoa());
        if (enfermeiro != null) {
            return ("Enfermeiro");
        }
        Medico medico = MedicoController.getMedico(pessoa.getCodPessoa());
        if (medico != null) {
            return ("Médico");
        }
        Paciente paciente = PacienteController.getPaciente(pessoa.getCodPessoa());
        if (paciente != null) {
            return ("Paciente");
        }
        Secretario secretario = SecretarioController.getSecretario(pessoa.getCodPessoa());
        if (secretario != null) {
            return ("Secretário");
        }
        return ("Desconhecido");
    }

    public String[] getColumns() {
        String[] aux = {"Código", "Nome", "Sexo", "CPF", "RG",
            "Rua", "Número", "Complemento", "Bairro", "Cidade", "CEP"};
        return (aux);
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return (false);
            }
        };

        for (int i = 0; i <= this.getColumns().length - 1; i++) {
            String[] aux = this.getColumns();
            model.addColumn(aux[i]);
            //model.ge
        }
        model.setNumRows(0);
        for (Pessoa pessoa : this.select()) {
            model.addRow(new Object[]{pessoa.getCodPessoa(),
                pessoa.getNome(),
                Lib.iif(pessoa.getSexo() == 'M', "Masculino", "Feminino"),
                pessoa.getCpf(),
                pessoa.getRg(),
                pessoa.getRua(),
                pessoa.getNumero(),
                pessoa.getComplemento(),
                pessoa.getBairro(),
                pessoa.getCidade(),
                pessoa.getCep()});
        }
        return (model);
    }
}
