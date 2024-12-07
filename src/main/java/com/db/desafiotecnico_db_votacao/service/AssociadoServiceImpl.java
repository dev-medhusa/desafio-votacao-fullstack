package com.db.desafiotecnico_db_votacao.service;

import com.db.desafiotecnico_db_votacao.model.Associado;
import com.db.desafiotecnico_db_votacao.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    @Override
    public Associado save(Associado associado) {
        return associadoRepository.save(associado);
    }

    @Override
    public List<Associado> findAll() {
        return associadoRepository.findAll();
    }

    @Override
    public Optional<Associado> findById(Long id) {
        return associadoRepository.findById(id);
    }

    @Override
    public Optional<Associado> findByCpf(String cpf) {
        return associadoRepository.findByCpf(cpf);
    }

    @Override
    public void deleteById(Long id) {
        associadoRepository.deleteById(id);
    }
}
