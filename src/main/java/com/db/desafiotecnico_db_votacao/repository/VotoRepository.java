package com.db.desafiotecnico_db_votacao.repository;

import com.db.desafiotecnico_db_votacao.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    List<Voto> findByVotacaoId(Long votacaoId);

    boolean existsByPautaIdAndAssociadoId(Long pautaId, Long associadoId);
}

public interface VotoRepository extends JpaRepository<Voto, Long> {
    boolean existsByPautaIdAndAssociadoId(Long pautaId, Long associadoId);
}


