package com.db.desafiotecnico_db_votacao.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Votacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pauta_id" , nullable = false)
    private Pauta pauta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public StatusVotacao getStatus() {
        return status;
    }

    public void setStatus(StatusVotacao status) {
        this.status = status;
    }

    public int getTempoVotacao() {
        return tempoVotacao;
    }

    public void setTempoVotacao(int tempoVotacao) {
        this.tempoVotacao = tempoVotacao;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    @Enumerated(EnumType.STRING)
    private StatusVotacao status; // status da votação (ABERTA ou FECHADA)

    private int tempoVotacao; // tempo de duração da votação em minutos

    @OneToMany(mappedBy = "votacao")
    private List<Voto> votos; // relacionamento com os votos dos associados


    public enum StatusVotacao {
        ABERTA,
        FECHADA
    }



}
