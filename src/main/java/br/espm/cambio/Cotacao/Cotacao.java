package br.espm.cambio.Cotacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Data
public class Cotacao {
    
    private UUID id;
    private UUID idMoeda;
    private LocalDate dtData;
    private BigDecimal vrValor;

}
