package br.espm.cambio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambioResource {

    @Autowired
    private MoedaService moedaService;

    @Autowired
    private CotacaoService cotacaoService;

    @GetMapping("/moeda")
    public List<Moeda> listMoeda() {
        return moedaService.listaAll();
    }

    @GetMapping("/moeda/{simbolo}")
    public Moeda findMoedaBySimbolo(@PathVariable String simbolo) {
        return moedaService.findBySimbolo(simbolo);
    }

    @GetMapping("/cotacao/{simbolo}")
    public Cotacao findCotacaoBySimbolo(@PathVariable String simbolo) {
        Moeda moeda = moedaService.findBySimbolo(simbolo);
        return cotacaoService.findByMoedaId(moeda.getId());
    }

    @PostMapping("/moeda")
    public ResponseEntity<String> save(@RequestBody(required = false) Moeda moeda) {
        if (moedaService.checkExists(moeda)) {
            return ResponseEntity.badRequest().body("Ja existe uma moeda com esse simbolo");};
        moedaService.create(moeda);
        return ResponseEntity.ok().body("Moeda criada com sucesso");
    }

    @RequestMapping(value = "/cotacao/{simbolo}/{ano}/{mes}/{dia}", method=RequestMethod.POST)
    public ResponseEntity<String> save(@PathVariable("simbolo") String simbolo,
                                         @PathVariable("ano") String ano, @PathVariable("mes") String mes,
                                         @PathVariable("dia") String dia, @RequestBody Map<String, String> valor) {
        String id = moedaService.findBySimbolo(simbolo).getId().toString();
        //Invalida requisicao se nao existe alguma moeda com o simbolo
        if (id == null) {return ResponseEntity.badRequest().body("Nao ha nenhuma moeda com esse simbolo");}
        try {
            //Formata data e valor
            LocalDate data = LocalDate.parse(ano+"-"+mes+"-"+dia); 
            BigDecimal valorBigD = new BigDecimal(valor.get("valor"));
            //Instancia cotacao e invalida se ja existe para a mesma data
            Cotacao cotacao = new Cotacao(id, data, valorBigD);
            if (cotacaoService.checkExists(cotacao)) {
                return ResponseEntity.badRequest().body("Ja existe uma cotacao para essa data");};
            //Cria cotacao
            cotacaoService.create(cotacao);
            return ResponseEntity.ok().body("Cotacao criada com sucesso");
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Data invalida");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("erro");
        }
       
    }
}
