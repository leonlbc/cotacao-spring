package br.espm.cambio.Moeda;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.espm.cambio.Exception.AlreadyExistsException;

/* 
 * Esse e o microservico de moeda
 */
@Component
public class MoedaService{

    @Autowired
    private MoedaRepository moedaRepository;

    public List<Moeda> listaAll() {
        return StreamSupport.stream(
                moedaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(MoedaModel::to).collect(Collectors.toList());
    }

    public Moeda create(Moeda moeda) {
        Moeda existingMoeda = moedaRepository.findById(moeda.getSimbolo())
        .map(MoedaModel::to)
        .orElse(null);
        if (existingMoeda == null) {
            return moedaRepository.save(new MoedaModel(moeda)).to();
        }
        else {
            throw new AlreadyExistsException();
        }
    }

    public Moeda findBySimbolo(String simbolo) {
        return moedaRepository.findBySimbolo(simbolo)
                    .map(MoedaModel::to).orElseThrow(
                        () -> new NoSuchElementException("Nenhuma moeda com esse simbolo")
                        );
    }
    
}
