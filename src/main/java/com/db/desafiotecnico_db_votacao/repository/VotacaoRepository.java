package com.db.desafiotecnico_db_votacao.repository;

import com.db.desafiotecnico_db_votacao.model.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
}
