package com.db.desafiotecnico_db_votacao.service;

import com.db.desafiotecnico_db_votacao.model.Pauta;

import java.util.List;
import java.util.Optional;


public interface PautaService {

    Pauta save(Pauta pauta);

    List<Pauta> findAll();

    Optional<Pauta> findById(Long id);

    Pauta update(Pauta pauta);

    void deletedById(Long id);

    void atualizarStatusDasSessoes();
}
