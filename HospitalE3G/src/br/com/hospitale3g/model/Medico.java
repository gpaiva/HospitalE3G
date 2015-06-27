package br.com.hospitale3g.model;

public class Medico extends Pessoa {
    //atributo de médico
    private String crm;

    public Medico() {
    }
    //construtor padrão de médico
    public Medico(Pessoa pessoa, String crm) {
        super();
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setNome(pessoa.getNome());
        this.setCpf(pessoa.getCpf());
        this.setRg(pessoa.getRg());
        this.setSexo(pessoa.getSexo());
        this.setCrm(crm);
    }
    //sets e gets
    public String getCrm() {
        return (this.crm);
    }

    public final void setCrm(String crm) {
        this.crm = crm;
    }
}
