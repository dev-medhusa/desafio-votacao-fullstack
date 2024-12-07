package com.db.desafiotecnico_db_votacao.repository;

import com.db.desafiotecnico_db_votacao.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    Optional<Associado> findByCpf(String cpf);
}
