package br.com.hospitale3g.model;

public class Pessoa {

    private int codPessoa;
    private String nome;
    private String cpf;
    private String rg;
    private char sexo;

    public Pessoa() {
    }

    public Pessoa(int codPessoa, String nome, char sexo, String cpf, String rg) {
        this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setSexo(sexo);
        this.setCpf(cpf);
        this.setRg(rg);
    }

    public int getCodPessoa() {
        return (this.codPessoa);
    }

    public final void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNome() {
        return (this.nome);
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return (this.cpf);
    }

    public final void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return (this.rg);
    }

    public final void setRg(String rg) {
        this.rg = rg;
    }

    public char getSexo() {
        return (this.sexo);
    }

    public final void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
