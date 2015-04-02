package model;

public class Usuario extends Pessoa{
    private String usuLogin;
    private String usuSenha;
    
    public Usuario(){
    }
    
    public String getUsuLogin(){
        return(this.usuLogin);
    }
    
    public void setUsuLogin(String usuLogin){
        this.usuLogin = usuLogin;
    }
    
    public String getUsuSenha(){
        return(this.usuSenha);
    }
    
    public void setUsuSenha(String usuSenha){
        this.usuSenha = usuSenha;
    }
}
