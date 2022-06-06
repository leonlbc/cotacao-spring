package br.espm.cambio.Moeda;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Moeda {

    private UUID id;
    @NotBlank
    private String nome;
    @NotBlank
    private String simbolo;

    public Moeda(){this.id = UUID.randomUUID();}
    public Moeda(String nome, String simbolo){
        this.nome = nome;
        this.simbolo = simbolo;
        this.id = UUID.randomUUID();
    }
}