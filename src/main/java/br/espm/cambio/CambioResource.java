package br.espm.cambio;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

@Validated
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
    public void saveMoeda(@RequestBody @Valid Moeda moeda) {
        moedaService.create(moeda);
    }

    @GetMapping("/cotacao/{simbolo}")
    public Cotacao findCotacaoBySimbolo(@PathVariable String simbolo) {
        Moeda moeda = moedaService.findBySimbolo(simbolo);
        return cotacaoService.findByMoedaId(moeda.getId());
    }

    @RequestMapping(value = "/cotacao/{simbolo}/{ano}/{mes}/{dia}", method=RequestMethod.POST)
    public void saveCotacao(@PathVariable String simbolo,@PathVariable String ano, @PathVariable String mes,
                                         @PathVariable String dia, @RequestBody CotacaoParcial cotp) {
        //Procura Moeda para verificar se existe
        UUID idMoeda = moedaService.findBySimbolo(simbolo).getId();
        //Tenta fazer parse da data
        LocalDate data = Cotacao.parseData(ano, mes, dia);
        //Instancia nova cotacao e tenta salva-la
        Cotacao cotacao = new Cotacao(idMoeda, data, cotp.getValor());
        cotacaoService.create(cotacao);
    }
}
