package br.com.hospitale3g.model;

public class Paciente extends Pessoa {

    private Integer id;

    public Paciente() {
    }

    public Paciente(Pessoa pessoa, Integer id) {
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setId(id);
    }

    public int getId() {
        return (this.id);
    }

    public final void setId(int id) {
        this.id = id;
    }
}
