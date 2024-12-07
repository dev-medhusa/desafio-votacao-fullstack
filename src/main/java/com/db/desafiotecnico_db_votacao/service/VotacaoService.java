package com.db.desafiotecnico_db_votacao.service;

import com.db.desafiotecnico_db_votacao.model.Votacao;

import java.util.List;
import java.util.Optional;

//metodos que vao ser implementados
public interface VotacaoService {

    Votacao save(Votacao votacao);

    List<Votacao> findAll();

    Optional<Votacao> findById(Long id);

    void deleteById(Long id);
}
