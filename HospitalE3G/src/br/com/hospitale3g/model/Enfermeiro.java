package br.com.hospitale3g.model;

public class Enfermeiro extends Pessoa {
    //atributo de enfermeiro        
    private String coren;

    public Enfermeiro() {
    }
    //construtor completo de enfermeiro
    public Enfermeiro(Pessoa pessoa, String coren) {
        super();
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setNome(pessoa.getNome());
        this.setCpf(pessoa.getCpf());
        this.setRg(pessoa.getRg());
        this.setSexo(pessoa.getSexo());

        this.setCoren(coren);
    }
    //set e get
    public String getCoren() {
        return (this.coren);
    }

    public final void setCoren(String coren) {
        this.coren = coren;
    }
}
