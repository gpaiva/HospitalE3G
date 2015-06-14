package br.com.hospitale3g.model;

public class Paciente extends Pessoa {

    private Integer id;

    public Paciente() {
    }

    public Paciente(Pessoa pessoa, Integer id) {
        super();
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setNome(pessoa.getNome());
        this.setCpf(pessoa.getCpf());
        this.setRg(pessoa.getRg());
        this.setSexo(pessoa.getSexo());
        
        this.setId(id);
    }

    public int getId() {
        return (this.id);
    }

    public final void setId(int id) {
        this.id = id;
    }
}
