package br.com.hospitale3g.model;

import java.util.Date;

public final class Atendimento {

    private int atenCodigo;
    private String crm;
    private int id;
    private String coren;
    private Date atenDataHora;
    private Date atenDataHoraFinalizado;
    private int atenSituacao;

    public Atendimento() {
    }

    public Atendimento(int atenCodigo, String crm, int id, String coren,
            Date atenDataHora, Date atenDataHoraFinalizado, int atenSituacao) {
        this.setAtenCodigo(atenCodigo);
        this.setCrm(crm);
        this.setId(id);
        this.setCoren(coren);
        this.setAtenDataHora(atenDataHora);
        this.setAtenDataHoraFinalizado(atenDataHoraFinalizado);
        this.setAtenSituacao(atenSituacao);
    }

    public Atendimento(int atenCodigo, String crm, int id, Date atenDataHora,
            int atenSituacao) {
        this.setAtenCodigo(atenCodigo);
        this.setCrm(crm);
        this.setId(id);
        this.setCoren(coren);
        this.setAtenDataHora(atenDataHora);
        this.setAtenDataHoraFinalizado(atenDataHoraFinalizado);
        this.setAtenSituacao(atenSituacao);
    }

    public int getAtenCodigo() {
        return atenCodigo;
    }

    public void setAtenCodigo(int atenCodigo) {
        this.atenCodigo = atenCodigo;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public Date getAtenDataHora() {
        return (this.atenDataHora);
    }

    public void setAtenDataHora(Date atenDataHora) {
        this.atenDataHora = atenDataHora;
    }

    public Date getAtenDataHoraFinalizado() {
        return (this.atenDataHoraFinalizado);
    }

    public void setAtenDataHoraFinalizado(Date atenDataHoraFinalizado) {
        this.atenDataHoraFinalizado = atenDataHoraFinalizado;
    }

    public int getAtenSituacao() {
        return atenSituacao;
    }

    public void setAtenSituacao(int atenSituacao) {
        this.atenSituacao = atenSituacao;
    }

}
