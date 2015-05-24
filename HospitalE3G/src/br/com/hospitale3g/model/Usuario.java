package br.com.hospitale3g.model;

public class Usuario extends Pessoa{
    private String usuLogin;
    private String usuSenha;
    
    public Usuario(){
    }
    
    public Usuario(Pessoa pessoa, String usuLogin, String usuSenha){
        this.setCodPessoa(pessoa.getCodPessoa());
        this.setNome(pessoa.getNome());
        this.setCpf(pessoa.getCpf());
        this.setRg(pessoa.getRg());
        this.setSexo(pessoa.getSexo());
        this.setUsuLogin(usuLogin);
        this.setUsuSenha(usuSenha);
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
