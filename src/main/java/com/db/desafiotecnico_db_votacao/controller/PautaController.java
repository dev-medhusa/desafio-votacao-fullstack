package com.db.desafiotecnico_db_votacao.controller;


import com.db.desafiotecnico_db_votacao.model.Pauta;
import com.db.desafiotecnico_db_votacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  //controlador  rest
@RequestMapping("api/v1/pauta")  //url base para os endpoints
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @GetMapping  //busca todas as pautas
    public ResponseEntity<List<Pauta>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(pautaService.findAll());
    }

   @GetMapping("/{id}")   //busca uma pauta pelo id
    public ResponseEntity<Optional<Pauta>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(pautaService.findById(id));
   }

   @PostMapping   //cria uma nova pauta
    public ResponseEntity<Pauta> create(@RequestBody Pauta pauta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pautaService.save(pauta));
   }

   @PutMapping  //atualiza iuma pauta
    public ResponseEntity<Pauta> update(@RequestBody Pauta pauta) {
        return ResponseEntity.status(HttpStatus.OK).body(pautaService.update(pauta));
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        pautaService.deletedById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
   }

    @PutMapping("/atualizar-status")
    public ResponseEntity<String> atualizarStatusDasSessoes() {
        pautaService.atualizarStatusDasSessoes(); // chama a logica do service
        return ResponseEntity.status(HttpStatus.OK).body("Status das sessões atualizado com sucesso!");
    }


}
