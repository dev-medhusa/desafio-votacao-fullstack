package com.db.desafiotecnico_db_votacao.controller;

import com.db.desafiotecnico_db_votacao.model.Associado;
import com.db.desafiotecnico_db_votacao.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @GetMapping
    public ResponseEntity<List<Associado>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(associadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Associado>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(associadoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Associado> create(@RequestBody Associado associado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(associadoService.save(associado));
    }

    @PutMapping
    public ResponseEntity<Associado> update(@RequestBody Associado associado) {
        return ResponseEntity.status(HttpStatus.OK).body(associadoService.save(associado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        associadoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
