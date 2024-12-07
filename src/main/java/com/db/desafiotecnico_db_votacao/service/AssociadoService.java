package com.db.desafiotecnico_db_votacao.service;

import com.db.desafiotecnico_db_votacao.model.Associado;

import java.util.List;
import java.util.Optional;

public interface AssociadoService {

    Associado save(Associado associado);

    List<Associado> findAll();

    Optional<Associado> findById(Long id);

    Optional<Associado> findByCpf(String cpf);

    void deleteById(Long id);
}