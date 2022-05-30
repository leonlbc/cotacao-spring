package br.espm.cambio.Moeda;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IMoedaService {
    List<Moeda> listaAll();
    Moeda create(Moeda moeda);
    boolean checkExists(Moeda moeda);
    Moeda findBySimbolo(String simbolo);
}
