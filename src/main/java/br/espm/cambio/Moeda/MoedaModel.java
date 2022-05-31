package br.espm.cambio.Moeda;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "moeda")
public class MoedaModel {

    @Id
    @Column(name = "id_moeda")
    private String idMoeda;

    @NotBlank(message = "Nome da moeda")
    @Column(name = "tx_nome")
    private String txNome;

    @NotBlank(message = "Simbolo da moeda")
    @Column(name = "tx_simbolo")
    private String txSimbolo;

    public MoedaModel() {

    }

    public MoedaModel(Moeda moeda) {
        this.idMoeda = moeda.getId().toString();
        this.txNome = moeda.getNome();
        this.txSimbolo = moeda.getSimbolo();
    }

    public Moeda to() {
        if (this.idMoeda != null && this.txNome != null && this.txSimbolo != null) {
            Moeda moeda = new Moeda();
            moeda.setId(UUID.fromString(this.idMoeda));
            moeda.setNome(this.txNome);
            moeda.setSimbolo(this.txSimbolo);
            return moeda;
        }
        return null;
    }

}
