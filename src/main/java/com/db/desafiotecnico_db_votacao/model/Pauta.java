package com.db.desafiotecnico_db_votacao.model;


import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.BatchSize;

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


    private LocalDateTime endTime; //data e hora do termino da sessao

    @Column(nullable = false)
    private Integer duracao = 1; // valor padrao em minutos


    public Pauta(String titulo, String descricao, Integer duracao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now(); //define data e hora da criação
        this.status = StatusSessao.ABERTA; //status inicial da sessao
        this.duracao = duracao != null && duracao > 0 ? duracao : 1; //define padrao se a duracao nao for valida
        this.endTime = dataCriacao.plusMinutes(this.duracao); //calcula o tempo de termino da sessao
        atualizarStatus(); //chama o metodo para atualizar o status
    }


    public enum StatusSessao {
        ABERTA, FECHADA
    }

    //verifica se a sessao precisa ser atualizada
    public void atualizarStatus() {
        if (LocalDateTime.now().isAfter(endTime)) {
            this.status = StatusSessao.FECHADA; //se o tempo do termino foi alcançado
        } else {
            this.status = StatusSessao.ABERTA; //caso contrario, aberta
        }
    }


}
