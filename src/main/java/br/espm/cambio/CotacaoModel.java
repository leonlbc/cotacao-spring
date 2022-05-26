package br.espm.cambio;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Cotacao")
public class CotacaoModel {
    @Id
    @Column(name = "id_cotacao")
    private String idCotacao;

    @Column(name = "id_moeda")
    private String idMoeda;

    @Column(name = "dt_data")
    @Temporal(TemporalType.DATE)
    private String dtData;

    @Column(name = "vr_valor")
    private float vrValor;

    public CotacaoModel(){}


    public CotacaoModel(Cotacao cotacao) {
        this.idCotacao = cotacao.getIdCotacao().toString();
        this.idMoeda = cotacao.getIdMoeda();
        this.dtData = cotacao.getDtData();
        this.vrValor = cotacao.getVrValor();

    }

    public Cotacao to(){
        Cotacao cotacao = new Cotacao();
        cotacao.setIdCotacao(UUID.fromString(this.idMoeda));
        cotacao.setIdMoeda(this.idMoeda);
        cotacao.setDtData(this.dtData);
        cotacao.setVrValor(this.vrValor);
        return cotacao;
     }
    }   
    
