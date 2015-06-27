package br.com.hospitale3g.model;

public class Secretario extends Pessoa {
    //atributo de secretário
    private int registro;
    
    public Secretario() {
    }
    //construtor completo de Secretário
    public Secretario(Pessoa pessoa, int registro) {
        super();
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setNome(pessoa.getNome());
        this.setCpf(pessoa.getCpf());
        this.setRg(pessoa.getRg());
        this.setSexo(pessoa.getSexo());
        this.setRegistro(registro);
    }

    public int getRegistro() {
        return (this.registro);
    }

    public final void setRegistro(int registro) {
        this.registro = registro;
    }
}
