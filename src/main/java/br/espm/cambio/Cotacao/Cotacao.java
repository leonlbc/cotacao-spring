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
    private LocalDate data;
    private BigDecimal valor;

    public Cotacao(){this.id = UUID.randomUUID();}

    public Cotacao(UUID idMoeda,LocalDate data, BigDecimal valor){
        this.id = UUID.randomUUID();
        this.idMoeda = idMoeda;
        this.data = data;
        this.valor = valor;
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

    public CotacaoResponse toResponse(){
        CotacaoResponse cotacaoResponse = new CotacaoResponse();
        cotacaoResponse.setId(this.id);
        cotacaoResponse.setData(this.data);
        cotacaoResponse.setValor(this.valor);
        return cotacaoResponse;
    }
}
