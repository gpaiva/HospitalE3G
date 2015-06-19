package br.com.hospitale3g.model;

import java.util.Date;

public final class Atendimento {

    private int atenCodigo;
    private String crm;
    private int id;
    private String coren;
    private String atenData;
    private String atenHora;
    private String atenDataFinalizado;
    private String atenHoraFinalizado;
    private int atenSituacao;
    private String atenObservacao;

    public Atendimento() {
    }

    public Atendimento(int atenCodigo, String crm, int id, String coren,
            String atenData, String atenHora, String atenDataFinalizado,
            String atenHoraFinalizado, int atenSituacao, String atenObservacao) {
        this.setAtenCodigo(atenCodigo);
        this.setCrm(crm);
        this.setId(id);
        this.setCoren(coren);
        this.setAtenData(atenData);
        this.setAtenHora(atenHora);
        this.setAtenDataFinalizado(atenDataFinalizado);
        this.setAtenHoraFinalizado(atenHoraFinalizado);
        this.setAtenSituacao(atenSituacao);
        this.setAtenObservacao(atenObservacao);
    }

    public Atendimento(int atenCodigo, String crm, int id, String atenData, String atenHora, String atenDataFinalizado,
            String atenHoraFinalizado,
            int atenSituacao, String atenObservacao) {
        this.setAtenCodigo(atenCodigo);
        this.setCrm(crm);
        this.setId(id);
        this.setCoren(coren);
        this.setAtenData(atenData);
        this.setAtenHora(atenHora);
        this.setAtenDataFinalizado(atenDataFinalizado);
        this.setAtenHoraFinalizado(atenHoraFinalizado);
        this.setAtenSituacao(atenSituacao);
        this.setAtenObservacao(atenObservacao);
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

    public String getAtenData() {
        return (this.atenData);
    }

    public void setAtenData(String atenData) {
        this.atenData = atenData;
    }

    public String getAtenHora() {
        return (this.atenHora);
    }

    public void setAtenHora(String atenHora) {
        this.atenHora = atenHora;
    }

    public String getAtenDataFinalizado() {
        return (this.atenDataFinalizado);
    }

    public void setAtenDataFinalizado(String atenDataFinalizado) {
        this.atenDataFinalizado = atenDataFinalizado;
    }

    public String getAtenHoraFinalizado() {
        return (this.atenHoraFinalizado);
    }

    public void setAtenHoraFinalizado(String atenHoraFinalizado) {
        this.atenHoraFinalizado = atenHoraFinalizado;
    }

    public int getAtenSituacao() {
        return atenSituacao;
    }

    public void setAtenSituacao(int atenSituacao) {
        this.atenSituacao = atenSituacao;
    }

    public String getAtenObservacao() {
        return (this.atenObservacao);
    }

    public void setAtenObservacao(String atenObservacao) {
        this.atenObservacao = atenObservacao;
    }
}
