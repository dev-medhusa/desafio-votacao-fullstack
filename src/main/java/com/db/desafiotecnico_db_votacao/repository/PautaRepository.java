package com.db.desafiotecnico_db_votacao.repository;

import com.db.desafiotecnico_db_votacao.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;


//auxilia na abstraçao da camada de dados na aplicaçao
public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
