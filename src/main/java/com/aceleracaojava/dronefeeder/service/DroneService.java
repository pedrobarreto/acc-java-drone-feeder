package com.aceleracaojava.dronefeeder.service;

import com.aceleracaojava.dronefeeder.dto.DroneDto;
import com.aceleracaojava.dronefeeder.entity.Drone;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.repository.DroneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DroneService.
 */
@Service
public class DroneService implements ServiceInterface<DroneDto, Drone> {

  @Autowired
  DroneRepository repository;

  @Override
  public Drone create(DroneDto object) {
    // TODO Auto-generated method stub
    Drone newDrone = new Drone();
    newDrone.setNome(object.getNome());
    return repository.save(newDrone);
  }

  @Override
  public Drone findById(Long id) {
    // TODO Auto-generated method stub
    return repository.findById(id).get();
  }

  @Override
  public List<Drone> findAll() {
    // TODO Auto-generated method stub
    return repository.findAll();
  }

  @Override
  public void update(Long id, DroneDto object) {
    Drone toUpdate = repository.findById(id).get();
    toUpdate.setLatitude(object.getLatitude());
    toUpdate.setLongitude(object.getLongitude());
    toUpdate.setStatus(object.getStatus());
    repository.save(toUpdate);

  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    repository.deleteById(id);;

  }

  public List<Entrega> getEntregas(Long id) {
    return repository.findById(id).get().getEntregas();
  }


}
