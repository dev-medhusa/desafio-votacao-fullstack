package com.db.desafiotecnico_db_votacao.service;

import com.db.desafiotecnico_db_votacao.model.Voto;
import com.db.desafiotecnico_db_votacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public abstract class VotoServiceImpl implements VotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Override
    public Voto save(Voto voto) {
        return votoRepository.save(voto);
    }

    @Override
    public List<Voto> findAll() {
        return votoRepository.findAll();
    }

    @Override
    public Optional<Voto> findById(Long id) {
        return votoRepository.findById(id);
    }

    @Override
    public List<Voto> findByVotacaoId(Long votacaoId) {
        return votoRepository.findByVotacaoId(votacaoId);
    }

    @Override
    public void deleteById(Long id) {
        votoRepository.deleteById(id);
    }
}
