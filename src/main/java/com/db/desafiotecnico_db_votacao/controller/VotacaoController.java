package com.db.desafiotecnico_db_votacao.controller;

import com.db.desafiotecnico_db_votacao.model.Votacao;
import com.db.desafiotecnico_db_votacao.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/votacao")
public class VotacaoController {

    @Autowired
    private VotacaoService votacaoService;

    @GetMapping
    public ResponseEntity<List<Votacao>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(votacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Votacao>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(votacaoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Votacao> create(@RequestBody Votacao votacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(votacaoService.save(votacao));
    }

    @PutMapping
    public ResponseEntity<Votacao> update(@RequestBody Votacao votacao) {
        return ResponseEntity.status(HttpStatus.OK).body(votacaoService.save(votacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        votacaoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
