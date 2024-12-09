package com.db.desafiotecnico_db_votacao.service;

import com.db.desafiotecnico_db_votacao.model.Pauta;
import com.db.desafiotecnico_db_votacao.repository.PautaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PautaServiceImpl implements  PautaService {

    @Autowired
    private PautaRepository pautaRepository; //interage com a tabela de pautas no banco de dados

    @Override
    public Pauta save (Pauta pauta) {
        return pautaRepository.save(pauta); //recebe um objeto pauta e salva no banco de dados usando o metodo save
    }  //save é um metodo do springdata que pode ser usado para criar ou atualizar um registro na tabela de pautas

    @Override
    public List<Pauta> findAll() {
        return pautaRepository.findAll();
    } //retorna todas as pautas da tabela

    @Override
    public Optional<Pauta> findById(Long id) {
        return pautaRepository.findById(id); //retorna pauta especifica a partir de seu id
    }

    @Override
    public Pauta update(Pauta pauta) {
        return pautaRepository.save(pauta); // atualiza uma pauta, o update chama o save para atualizar a pauta
    }

    @Override
    public void deletedById(Long id) {
        pautaRepository.deleteById(id); //deleta uma pauta a partir do seu id
    }


    //atualizando o status da sessao de votaçao
    //verifica o tempo da sessao e altera o status conforme necessario
    public void updateVotingSessionStatus() {
        List<Pauta> pautas = pautaRepository.findAll();
        for (Pauta pauta : pautas) {
            if (LocalDateTime.now().isAfter(pauta.getEndTime())) {
                pauta.setStatus(Pauta.StatusSessao.FECHADA);
                pautaRepository.save(pauta);
            }
        }
    }

    public Pauta abrirSessao(Long pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new EntityNotFoundException("Pauta não encontrada"));

        if (pauta.getStatus() == Pauta.StatusSessao.ABERTA) {
            throw new IllegalStateException("Sessão já está aberta para esta pauta. ");
        }

        pauta.setStatus(Pauta.StatusSessao.ABERTA);
        pauta.setDataCriacao(LocalDateTime.now());
        pauta.setEndTime(pauta.getDataCriacao().plusMinutes(pauta.getDuracao()));

        return pautaRepository.save(pauta);

    }



}
