package br.com.hospitale3g.model;

public class Medico extends Pessoa {

    private String crm;

    public Medico() {
    }

    public Medico(Pessoa pessoa, String crm) {
        super();
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setNome(pessoa.getNome());
        this.setCpf(pessoa.getCpf());
        this.setRg(pessoa.getRg());
        this.setSexo(pessoa.getSexo());
        this.setCrm(crm);
    }

    public String getCrm() {
        return (this.crm);
    }

    public final void setCrm(String crm) {
        this.crm = crm;
    }
}
