package br.espm.cambio;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CotacaoRepository extends CrudRepository<CotacaoModel, String> {

    @Override
    Iterable<CotacaoModel> findAll();
    
    @Query("SELECT m from CotacaoModel m WHERE UPPER(m.dtData) = UPPER(:data)")
    Optional<CotacaoModel> findByDate(@Param("data") LocalDate dtData);

    @Query("SELECT m from CotacaoModel m WHERE UPPER(m.idMoeda) = UPPER(:idMoeda)")
    Optional<CotacaoModel> findByMoedaId(@Param("idMoeda") String idMoeda);

    Iterable<CotacaoModel> findAllByDtData(Date dtData);
    
}