package br.espm.cambio.Cotacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

// Classe ira ser JSONificada
// remove o idMoeda por ser redundante

@Data
public class CotacaoResponse {
    
    private UUID id;
    private LocalDate data;
    private BigDecimal valor;

}

