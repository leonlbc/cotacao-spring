package br.espm.cambio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Cotacao {
    private UUID id;
    private UUID idMoeda;
    private Date dtData;
    private BigDecimal vrValor;

    public UUID getId(){
        return id;
    }

    public Date getDtData() {
        return dtData;
    }

    public UUID getIdMoeda() {
        return idMoeda;
    }

    public BigDecimal getVrValor() {
        return vrValor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDtData(Date dtData) {
        this.dtData = dtData;
    }

    public void setIdMoeda(UUID idMoeda) {
        this.idMoeda = idMoeda;
    }

    public void setVrValor(BigDecimal vrValor) {
        this.vrValor = vrValor;
    }
}
