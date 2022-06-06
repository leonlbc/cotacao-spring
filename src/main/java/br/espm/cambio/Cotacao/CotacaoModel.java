package br.espm.cambio.Cotacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cotacao")
public class CotacaoModel {

    @Id
    @Column(name = "id_cotacao")
    private String idCotacao;

    @Column(name = "id_moeda")
    private String idMoeda;

    @Column(name = "dt_data")
    private LocalDate dtData;

    @Column(name = "vr_valor")
    private BigDecimal vrValor;

    public CotacaoModel(){}

    public CotacaoModel(Cotacao cotacao) {
        this.idCotacao = cotacao.getId().toString();
        this.idMoeda = cotacao.getIdMoeda().toString();
        this.dtData = cotacao.getData();
        this.vrValor = cotacao.getValor();
    }

    public Cotacao to(){
        Cotacao cotacao = new Cotacao();
        cotacao.setId(UUID.fromString(this.idMoeda));
        cotacao.setIdMoeda(UUID.fromString(this.idMoeda));
        cotacao.setData(this.dtData);
        cotacao.setValor(this.vrValor);
        return cotacao;
     }
    }   
    
