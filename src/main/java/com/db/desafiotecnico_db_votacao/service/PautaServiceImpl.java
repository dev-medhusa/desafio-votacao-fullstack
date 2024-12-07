package com.db.desafiotecnico_db_votacao.service;

import com.db.desafiotecnico_db_votacao.model.Pauta;
import com.db.desafiotecnico_db_votacao.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public abstract class PautaServiceImpl implements  PautaService{

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

    private void updateVotingSessionStatus(Pauta pauta) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sessionEndTime = pauta.getDataCriacao().plusMinutes(pauta.getDuracao());
        
        //verifica se a sessao ja foi encerrada
        if (now.isAfter(sessionEndTime)) {
            pauta.setStatus("ENCERRADA");
        } else if (now.isBefore(sessionEndTime) && pauta.getStatus().equals("EM ANDAMENTO")) {
            pauta.setStatus("EM_ANDAMENTO");
        } else {
            pauta.setStatus("AGUARDANDO_INICIO"); //caso a sessao ainda nao tenha começado
        }
    }
}
