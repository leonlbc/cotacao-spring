package br.espm.cambio;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class CambioResource {

    @Autowired
    private MoedaService moedaService;

    @Autowired
    private CotacaoService cotacaoService;

    @Validated
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
        return cotacaoService.findById(moeda.getId());
    }

    @Validated
    @PostMapping("/moeda")
    ResponseEntity<String> save(@RequestBody(required = false) @Valid @NotNull Moeda moeda) {
        if (moedaService.checkExists(moeda)) {
            return ResponseEntity.badRequest().body("Ja existe uma moeda com esse simbolo");};
        moedaService.create(moeda);
        return ResponseEntity.ok().body("Moeda criada com sucesso");
    }
    
}
