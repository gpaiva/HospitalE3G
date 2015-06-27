package br.com.hospitale3g.model;

public class Paciente extends Pessoa {
    //atributo de Paciente
    private Integer id;
    
    public Paciente() {
    }
    //construtor completo de Paciente
    public Paciente(Pessoa pessoa, Integer id) {
        super();
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setNome(pessoa.getNome());
        this.setCpf(pessoa.getCpf());
        this.setRg(pessoa.getRg());
        this.setSexo(pessoa.getSexo());
        
        this.setId(id);
    }
    //Set e Get
    public int getId() {
        return (this.id);
    }

    public final void setId(int id) {
        this.id = id;
    }
}
