package com.aceleracaojava.dronefeeder.controller;

import com.aceleracaojava.dronefeeder.dto.DroneDto;
import com.aceleracaojava.dronefeeder.entity.Drone;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.service.DroneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DroneController.
 */
@RestController
@RequestMapping("/drones")
public class DroneController implements ControllerInterface<DroneDto, Drone> {

  @Autowired
  DroneService service;

  @PostMapping
  public Drone create(@RequestBody DroneDto object) {
    // TODO Auto-generated method stub
    System.out.println("AQUIII2");
    return service.create(object);
  }

  @GetMapping("/{id}/entregas")
  public List<Entrega> getEntregas(@PathVariable Long id) {
    return service.getEntregas(id);
  }

  @GetMapping("/{id}")
  public Drone findById(@PathVariable Long id) {
    // TODO Auto-generated method stub
    return service.findById(id);
  }

  @GetMapping
  public List<Drone> findAll() {
    // TODO Auto-generated method stub
    return service.findAll();
  }

  /**
   * Método update.
   */
  @PatchMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody DroneDto object) {
    // TODO Auto-generated method stub
    service.update(id, object);

  }

  /**
   * Método delete.
   */

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    // TODO Auto-generated method stub
    service.delete(id);

  }



}
