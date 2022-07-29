package com.aceleracaojava.dronefeeder.service;

import com.aceleracaojava.dronefeeder.dto.EntregaDto;
import com.aceleracaojava.dronefeeder.entity.Drone;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.repository.DroneRepository;
import com.aceleracaojava.dronefeeder.repository.EntregaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EntregaService.
 */
@Service
public class EntregaService implements ServiceInterface<EntregaDto, Entrega> {

  @Autowired
  private EntregaRepository repository;

  @Autowired
  DroneRepository droneRepo;

  @Override
  public Entrega create(EntregaDto object) {
    // TODO Auto-generated method stub
    Drone drone = droneRepo.findById(object.getDroneId()).get();
    Entrega newEntrega = new Entrega();
    drone.addEntrega(newEntrega);
    Drone saved = droneRepo.save(drone);
    return saved.getEntregas().get(saved.getEntregas().size() - 1);
  }

  @Override
  public Entrega findById(Long id) {
    // TODO Auto-generated method stub
    return repository.findById(id).get();
  }

  @Override
  public List<Entrega> findAll() {
    // TODO Auto-generated method stub
    return repository.findAll();
  }

  @Override
  public void update(Long id, EntregaDto object) {
    // TODO Auto-generated method stub
    Entrega toUpdate = repository.findById(id).get();
    toUpdate.setData(object.getData());
    toUpdate.setStatus(object.getStatus());
    repository.save(toUpdate);
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    repository.deleteById(id);

  }


}
