package com.db.desafiotecnico_db_votacao.service;

import com.db.desafiotecnico_db_votacao.model.Votacao;
import com.db.desafiotecnico_db_votacao.repository.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//implementaçao da interface
@Service
public class VotacaoServiceImpl implements VotacaoService {

    @Autowired
    private VotacaoRepository votacaoRepository;

    @Override
    public Votacao save(Votacao votacao) {
        return votacaoRepository.save(votacao);
    }

    @Override
    public List<Votacao> findAll() {
        return votacaoRepository.findAll();
    }

    @Override
    public Optional<Votacao> findById(Long id) {
        return votacaoRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        votacaoRepository.deleteById(id);
    }
}