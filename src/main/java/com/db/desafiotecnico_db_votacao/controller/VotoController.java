package com.db.desafiotecnico_db_votacao.controller;

import com.db.desafiotecnico_db_votacao.model.Voto;
import com.db.desafiotecnico_db_votacao.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @GetMapping
    public ResponseEntity<List<Voto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(votoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Voto>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(votoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Voto> create(@RequestBody Voto voto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(votoService.save(voto));
    }

    @PutMapping
    public ResponseEntity<Voto> update(@RequestBody Voto voto) {
        return ResponseEntity.status(HttpStatus.OK).body(votoService.save(voto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        votoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
