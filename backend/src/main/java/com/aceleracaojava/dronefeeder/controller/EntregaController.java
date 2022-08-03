package com.aceleracaojava.dronefeeder.controller;

import com.aceleracaojava.dronefeeder.dto.EntregaDto;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.service.EntregaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EntregaController.
 */
@CrossOrigin
@RestController
@RequestMapping("/entregas")
public class EntregaController implements ControllerInterface<EntregaDto, Entrega> {

  @Autowired
  EntregaService service;

  @PostMapping
  public ResponseEntity<Entrega> create(@RequestBody EntregaDto object) {
    // TODO Auto-generated method stub
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(object));
  }

  @GetMapping("/{id}")
  public Entrega findById(@PathVariable Long id) {
    // TODO Auto-generated method stub
    return service.findById(id);
  }

  @GetMapping
  public List<Entrega> findAll() {
    // TODO Auto-generated method stub
    return service.findAll();
  }

  /**
   * Método update.
   */
  @PatchMapping("/{id}")
  public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody EntregaDto object) {
    // TODO Auto-generated method stub
    service.update(id, object);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

  }

  /**
   * Método delete.
   */

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    // TODO Auto-generated method stub
    service.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

  }



}
