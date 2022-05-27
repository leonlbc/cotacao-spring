package br.espm.cambio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Cotacao {
    private UUID id;
    private UUID idMoeda;
    private LocalDate dtData;
    private BigDecimal vrValor;

    public Cotacao(){}

    public Cotacao(String idMoeda, LocalDate dtData, BigDecimal vrValor){
        this.idMoeda = UUID.fromString(idMoeda);
        this.dtData = dtData;
        this.vrValor = vrValor;
    }

    public UUID getId(){
        return id;
    }

    public LocalDate getDtData() {
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

    public void setDtData(LocalDate dtData) {
        this.dtData = dtData;
    }

    public void setIdMoeda(UUID idMoeda) {
        this.idMoeda = idMoeda;
    }

    public void setVrValor(BigDecimal vrValor) {
        this.vrValor = vrValor;
    }
}
