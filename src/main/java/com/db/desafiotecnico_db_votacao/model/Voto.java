package com.db.desafiotecnico_db_votacao.model;


import jakarta.persistence.*;


@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "associado_id", nullable = false)
    private Associado associado; //relacionamento com o associado

    @ManyToOne
    @JoinColumn(name = "votacao_id" , nullable = false)
    private Votacao votacao; //relacionamento com a votaçao

    @Enumerated(EnumType.STRING)
    private VotoOpcao voto; //voto sim ou nao


    //getters e setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public Votacao getVotacao() {
        return votacao;
    }

    public void setVotacao(Votacao votacao) {
        this.votacao = votacao;
    }

    public VotoOpcao getVoto() {
        return voto;
    }

    public void setVoto(VotoOpcao voto) {
        this.voto = voto;
    }

    public Object getAssociadoId() {
        return null;
    }

    public Object getPautaId() {
        return null;
    }

    public enum VotoOpcao {
        SIM,
        NAO
    }


}
