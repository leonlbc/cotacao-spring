package br.espm.cambio;

import java.util.UUID;

public class Cotacao {
    private UUID id;
    private UUID idMoeda;
    private String dtData;
    private float vrValor;

    public UUID getId(){
        return id;
    }

    public String getDtData() {
        return dtData;
    }

    public UUID getIdMoeda() {
        return idMoeda;
    }

    public float getVrValor() {
        return vrValor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDtData(String dtData) {
        this.dtData = dtData;
    }

    public void setIdMoeda(UUID idMoeda) {
        this.idMoeda = idMoeda;
    }

    public void setVrValor(float vrValor) {
        this.vrValor = vrValor;
    }
}
