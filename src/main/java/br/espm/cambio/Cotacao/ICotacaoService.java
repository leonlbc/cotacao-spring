package br.espm.cambio.Cotacao;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public interface ICotacaoService {
    List<Cotacao> listaAll();
    Cotacao create(Cotacao co);
    Cotacao findByMoedaId(UUID id);
}
