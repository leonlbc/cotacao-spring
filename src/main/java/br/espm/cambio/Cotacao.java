package br.espm.cambio;

import java.util.UUID;

public class Cotacao {
    private UUID idCotacao;
    private String idMoeda;
    private String dtData;
    private float vrValor;

    public UUID getIdCotacao(){
        return idCotacao;
    }

    public String getDtData() {
        return dtData;
    }

    public String getIdMoeda() {
        return idMoeda;
    }

    public float getVrValor() {
        return vrValor;
    }

    public void setIdCotacao(UUID idCotacao) {
        this.idCotacao = idCotacao;
    }

    public void setDtData(String dtData) {
        this.dtData = dtData;
    }

    public void setIdMoeda(String idMoeda) {
        this.idMoeda = idMoeda;
    }

    public void setVrValor(float vrValor) {
        this.vrValor = vrValor;
    }
}
