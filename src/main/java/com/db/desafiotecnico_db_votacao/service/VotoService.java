package com.db.desafiotecnico_db_votacao.service;
import java.util.List;
import java.util.Optional;
import com.db.desafiotecnico_db_votacao.model.Voto;

public interface VotoService {
     Voto save(Voto voto);

     List<Voto> findAll();

     Optional<Voto> findById(Long id);

     List<Voto> findByVotacaoId(Long votacaoId);

     void deletedById(Long id);


    void deleteById(Long id);
}
