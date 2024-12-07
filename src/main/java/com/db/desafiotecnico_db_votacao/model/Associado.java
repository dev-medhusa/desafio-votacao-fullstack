package com.db.desafiotecnico_db_votacao.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf; //para verificaçao do direito de voto

    @OneToMany(mappedBy = "associado")
    private List<Voto> votos;


    //getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
}
