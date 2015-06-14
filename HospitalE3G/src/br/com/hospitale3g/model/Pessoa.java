package br.com.hospitale3g.model;

public class Pessoa {

    private int codPessoa;
    private String nome;
    private String cpf;
    private String rg;
    private char sexo;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;

    public Pessoa() {
    }

    public Pessoa(int codPessoa, String nome, char sexo, String cpf, String rg,
            String rua, String numero, String complemento, String bairro,
            String cidade, String cep) {
        this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setSexo(sexo);
        this.setCpf(cpf);
        this.setRg(rg);
        this.setRua(rua);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setCep(cep);
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

    public String getRua() {
        return (this.rua);
    }

    public final void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return (this.numero);
    }

    public final void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return (this.complemento);
    }

    public final void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return (this.bairro);
    }

    public final void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return (this.cidade);
    }

    public final void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return (this.cep);
    }

    public final void setCep(String cep) {
        this.cep = cep;
    }
}
