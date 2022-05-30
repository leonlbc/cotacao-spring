package br.espm.cambio.Cotacao;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* 
 * Microservico de cotacao
 */
@Component
public class CotacaoService implements ICotacaoService{

    @Autowired
    private CotacaoRepository cotacaoRepository;

    public List<Cotacao> listaAll() {
        return StreamSupport
                // Transforma de iteravel para lista
                .stream(cotacaoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                // Transforma de Model para Objeto
                .stream().map(CotacaoModel::to)
                .collect(Collectors.toList());
    }

    public Cotacao create(Cotacao vo) {
        vo.setId(UUID.randomUUID());
        return cotacaoRepository.save(new CotacaoModel(vo)).to();
    }
    
    public Cotacao findByMoedaId(UUID id) {
        String idString = id.toString();
        return cotacaoRepository.findByMoedaId(idString)
                    .map(CotacaoModel::to)
                    .orElse(null);
    }

    public boolean checkExists(Cotacao cotacao) {
        return cotacaoRepository.findByDate(cotacao.getDtData(),
                 cotacao.getIdMoeda().toString()).isPresent();
    }

}
