package br.espm.cambio.Cotacao;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends CrudRepository<CotacaoModel, String> {

    @Override
    Iterable<CotacaoModel> findAll();
    
    @Query("SELECT c from CotacaoModel c WHERE UPPER(c.dtData) = UPPER(:data) and c.idMoeda = :idMoeda")
    Optional<CotacaoModel> findByDate(@Param("data") LocalDate dtData, @Param("idMoeda") String idMoeda);

    @Query("SELECT c from CotacaoModel c WHERE UPPER(c.idMoeda) = UPPER(:idMoeda)")
    Optional<CotacaoModel> findByMoedaId(@Param("idMoeda") String idMoeda);

    Iterable<CotacaoModel> findAllByDtData(Date dtData);
    
}