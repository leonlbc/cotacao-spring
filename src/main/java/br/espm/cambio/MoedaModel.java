package br.espm.cambio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moeda")
public class MoedaModel {
    
    @Id
    @Column(name = "id_moeda")
    private String idMoeda;

    @Column(name = "tx_nome")
    private String txNome;
    
    @Column(name = "tx_simbolo")
    private String txSimbolo;
    
    public Moeda to() {
        Moeda moeda = new Moeda();
        moeda.setNome(this.txNome);
        moeda.setSimbolo(this.txSimbolo);
        return moeda;
    }

    public MoedaModel() {

    }

    public MoedaModel(Moeda moeda) {
        this.txNome = moeda.getNome();
        this.txSimbolo = moeda.getSimbolo();
    }

}
