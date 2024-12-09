package com.db.desafiotecnico_db_votacao.service;

import com.db.desafiotecnico_db_votacao.model.Associado;
import com.db.desafiotecnico_db_votacao.model.Pauta;
import com.db.desafiotecnico_db_votacao.model.Votacao;
import com.db.desafiotecnico_db_votacao.model.Voto;
import com.db.desafiotecnico_db_votacao.repository.AssociadoRepository;
import com.db.desafiotecnico_db_votacao.repository.PautaRepository;
import com.db.desafiotecnico_db_votacao.repository.VotacaoRepository;
import com.db.desafiotecnico_db_votacao.repository.VotoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.time.LocalDateTime;
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

    //verificar se a votaçao está aberta
    public boolean isVotacaoAberta(Long pautaId) {
        Optional<Votacao> votacao = VotacaoRepository.findByPautaId(pautaId);
        return votacao.isPresent() && votacao.get().getStatus() == Votacao.StatusVotacao.ABERTA;
    }

    //verificar se o associado já votou
    public boolean jaVotou(Long pautaId, Long associadoId) {
        return votoRepository.existsByPautaIdAndAssociadoId(pautaId, associadoId);
    }

    @Override
    public Voto registrarVoto(Long pautaId, Long associadoId, String escolha) {
        Pauta pauta = PautaRepository.findById(pautaId)
                .orElseThrow(() -> new EntityNotFoundException("Pauta não encontrada"));

        if (pauta.getStatus() != Pauta.StatusSessao.ABERTA || pauta.getEndTime().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("A sessão de votação está encerrada");
        }

        if (votoRepository.existsByPautaIdAndAssociadoId(pautaId, associadoId)) {
            throw new IllegalStateException("Associado já votou nesta pauta");
        }

        Associado associado = AssociadoRepository.findById(Associado)
                .orElseThrow(() -> new EntityNotFoundException("Associado não encontrado");

                Voto voto = new Voto();
                voto.setPauta(pauta);
                voto.setAssociado(associado);
                voto.setEscolha(escolha);
                return votoRepository.save(voto);

    }


}

