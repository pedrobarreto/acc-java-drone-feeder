package com.aceleracaojava.dronefeeder.service;

import com.aceleracaojava.dronefeeder.dto.DroneDto;
import com.aceleracaojava.dronefeeder.entity.Drone;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.exceptions.DroneNaoEncontradoException;
import com.aceleracaojava.dronefeeder.repository.DroneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * DroneService.
 */
@Service
public class DroneService implements ServiceInterface<DroneDto, Drone> {

  @Autowired
  DroneRepository repository;

  @Override
  public Drone create(DroneDto object) {
    Assert.notNull(object.getNome(), "Nome não pode estar em branco");
    Drone newDrone = new Drone();
    newDrone.setNome(object.getNome());
    return repository.save(newDrone);
  }

  @Override
  public Drone findById(Long id) {
   try {
     return repository.findById(id).get();
   } catch (Exception e) {
    throw new DroneNaoEncontradoException(id.toString());
   }
  }

  @Override
  public List<Drone> findAll() {
    return repository.findAll();
  }

  @Override
  public void update(Long id, DroneDto object) {
    try {
      Drone drone = repository.findById(id).get();
      drone.setStatus(object.getStatus());
      drone.setLatitude(object.getLatitude());
      drone.setLongitude(object.getLongitude());
      repository.save(drone);
    } catch (Exception e) {
      throw new DroneNaoEncontradoException(id.toString());
    }
  }

  @Override
  public void delete(Long id) {
    try {
      repository.deleteById(id);
    } catch (Exception e) {
      throw new DroneNaoEncontradoException(id.toString());
    }

  }

  public List<Entrega> getEntregas(Long id) {
    try {
      Drone drone = repository.findById(id).get();
      return drone.getEntregas();
    } catch (Exception e) {
      throw new DroneNaoEncontradoException(id.toString());
    }
  }


}
