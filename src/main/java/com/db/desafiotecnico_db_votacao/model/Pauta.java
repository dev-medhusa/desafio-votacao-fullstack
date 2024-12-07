package com.db.desafiotecnico_db_votacao.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id vai ser gerado automaticamente pelo banco de dados
    private Long id;

    @Column(nullable = false)
    private String titulo; //titulo da pauta

    @Column(nullable = true)
    private String descricao; //descriçao da pauta

    @Column(nullable = false)
    private LocalDateTime dataCriacao; //data e hora da criaçao da sessao

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusSessao status; //status (aberto, fechado)

    @Column(nullable = false)
    private int duracao; //duracao da sessao em min

    private LocalDateTime endTime; //data e hora do termino da sessao



    public Pauta(String titulo, String descricao, int duracao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now(); //define data e hora da criação
        this.status = StatusSessao.ABERTA; //status inicial da sessao
        this.duracao = duracao;
        this.endTime = dataCriacao.plusMinutes(duracao); //calcula o tempo de termino da sessao
        atualizarStatus(); //chama o metodo para atualizar o status
    }

    public void setStatus(String encerrada) {

    }

    public enum StatusSessao {
        ABERTA, FECHADA, EM_ANDAMENTO
    }

    //verifica se a sessao precisa ser atualizada
    public void atualizarStatus() {
        if (LocalDateTime.now().isAfter(endTime)) {
            this.status = StatusSessao.FECHADA; //se o tempo do termino foi alcançado
        } else if (LocalDateTime.now().isBefore(endTime) && status == StatusSessao.ABERTA) {
            this.status = StatusSessao.EM_ANDAMENTO; // caso contrario
        }
    }


}
