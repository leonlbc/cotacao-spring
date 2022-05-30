package br.espm.cambio;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.espm.cambio.Cotacao.Cotacao;
import br.espm.cambio.Cotacao.CotacaoParcial;
import br.espm.cambio.Cotacao.CotacaoService;
import br.espm.cambio.Moeda.Moeda;
import br.espm.cambio.Moeda.MoedaService;

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

    @PostMapping("/moeda")
    public ResponseEntity<String> saveMoeda(@RequestBody Moeda moeda) {
        if (moedaService.checkExists(moeda)) {
            return ResponseEntity.badRequest().body("Ja existe uma moeda com esse simbolo");};
        moedaService.create(moeda);
        return ResponseEntity.ok().body("Moeda criada com sucesso");
    }

    @GetMapping("/cotacao/{simbolo}")
    public Cotacao findCotacaoBySimbolo(@PathVariable String simbolo) {
        Moeda moeda = moedaService.findBySimbolo(simbolo);
        return cotacaoService.findByMoedaId(moeda.getId());
    }

    @RequestMapping(value = "/cotacao/{simbolo}/{ano}/{mes}/{dia}", method=RequestMethod.POST)
    public ResponseEntity<String> saveCotacao(@PathVariable String simbolo,@PathVariable String ano, @PathVariable String mes,
                                         @PathVariable String dia, @RequestBody CotacaoParcial cotp) {
        UUID id = moedaService.findBySimbolo(simbolo).getId();
        if (id == null) {return ResponseEntity.badRequest().body("Nao ha nenhuma moeda com esse simbolo");}
        try {
            LocalDate data = LocalDate.parse(ano+"-"+mes+"-"+dia);
            Cotacao cotacao = new Cotacao();
            cotacao.setVrValor(cotp.getValor());
            cotacao.setDtData(data);
            cotacao.setIdMoeda(id);
            if (cotacaoService.checkExists(cotacao)) {
                return ResponseEntity.badRequest().body("Ja existe uma cotacao para esse simbolo nessa data");};
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
