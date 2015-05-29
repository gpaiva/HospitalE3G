package br.com.hospitale3g.model;

public class Enfermeiro extends Pessoa {

    private String coren;

    public Enfermeiro() {
    }

    public Enfermeiro(Pessoa pessoa, String coren) {
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setCoren(coren);
    }

    public String getCoren() {
        return (this.coren);
    }

    public final void setCoren(String coren) {
        this.coren = coren;
    }
}