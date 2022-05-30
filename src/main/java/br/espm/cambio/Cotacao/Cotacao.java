package br.espm.cambio.Cotacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.UUID;
import lombok.Data;

@Data
public class Cotacao {
    
    private UUID id;
    private UUID idMoeda;
    private LocalDate dtData;
    private BigDecimal vrValor;

    public Cotacao(){this.id = UUID.randomUUID();}

    public Cotacao(UUID idMoeda,LocalDate dtData, BigDecimal vrValor){
        this.id = UUID.randomUUID();
        this.idMoeda = idMoeda;
        this.dtData = dtData;
        this.vrValor = vrValor;
    }

    public static LocalDate parseData(String ano, String mes, String dia) {
        String data = ano+"-"+mes+"-"+dia;
        try {
            LocalDate dataParsed = LocalDate.parse(data);
            return dataParsed;
        } catch (Exception e) {
            throw new DateTimeParseException("Data invalida", data, 0);
        }
    }
}
