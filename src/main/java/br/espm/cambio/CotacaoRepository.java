package br.espm.cambio;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CotacaoRepository extends CrudRepository<CotacaoModel, String> {

    @Override
    Iterable<CotacaoModel> findAll();
    
    @Override
    Optional<CotacaoModel> findById(String id);

}