package model;

public class Pessoa {

    private int pesCodigo;
    private String pesNome;

    public Pessoa() {
    }
    
    public Pessoa(int pesCodigo, String pesNome){
        this.setPesCodigo(pesCodigo);
        this.setPesNome(pesNome);
    }

    public int getPesCodigo() {
        return (this.pesCodigo);
    }

    public final void setPesCodigo(int pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    public String getPesNome() {
        return (pesNome);
    }

    public final void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }
}
