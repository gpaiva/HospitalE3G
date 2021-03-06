package br.com.hospitale3g.model;

public class Usuario extends Pessoa{
    //declaração de atributos
    private String usuLogin;
    private String usuSenha;
    
    public Usuario(){
    }
    //construtor completo da clase usuario
    public Usuario(Pessoa pessoa, String usuLogin, String usuSenha){
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setNome(pessoa.getNome());
        this.setCpf(pessoa.getCpf());
        this.setRg(pessoa.getRg());
        this.setSexo(pessoa.getSexo());
        this.setUsuLogin(usuLogin);
        this.setUsuSenha(usuSenha);
    }
    
    public Usuario(Pessoa pessoa, String usuLogin){
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setNome(pessoa.getNome());
        this.setCpf(pessoa.getCpf());
        this.setRg(pessoa.getRg());
        this.setSexo(pessoa.getSexo());
        this.setUsuLogin(usuLogin);
    }
    
    public String getUsuLogin(){
        return(this.usuLogin);
    }
    
    public final void setUsuLogin(String usuLogin){
        this.usuLogin = usuLogin;
    }
    
    public String getUsuSenha(){
        return(this.usuSenha);
    }
    
    public final void setUsuSenha(String usuSenha){
        this.usuSenha = usuSenha;
    }
}
