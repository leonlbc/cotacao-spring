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

}
