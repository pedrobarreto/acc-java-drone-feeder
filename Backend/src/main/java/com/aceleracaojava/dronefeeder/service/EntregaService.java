package com.aceleracaojava.dronefeeder.service;

import com.aceleracaojava.dronefeeder.dto.EntregaDto;
import com.aceleracaojava.dronefeeder.entity.Drone;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.exceptions.DroneNaoEncontradoException;
import com.aceleracaojava.dronefeeder.exceptions.EntregaNaoEncontradaException;
import com.aceleracaojava.dronefeeder.repository.DroneRepository;
import com.aceleracaojava.dronefeeder.repository.EntregaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * EntregaService.
 */
@Service
public class EntregaService implements ServiceInterface<EntregaDto, Entrega> {

  @Autowired
  EntregaRepository repository;

  @Autowired
  DroneRepository droneRepo;

  @Override
  public Entrega create(EntregaDto object) {
    Assert.notNull(object.getDroneId(), "Drone Id não pode estar em branco");
    try {
      Drone drone = droneRepo.findById(object.getDroneId()).get();
      Entrega newEntrega = new Entrega();
      drone.addEntrega(newEntrega);
      Drone saved = droneRepo.save(drone);
    return saved.getEntregas().get(saved.getEntregas().size() - 1);
    } catch (Exception e) {
      throw new DroneNaoEncontradoException(object.getDroneId().toString());
    }
  }

  @Override
  public Entrega findById(Long id) {
    try {
      return repository.findById(id).get();
    } catch (Exception e) {
      throw new EntregaNaoEncontradaException(id.toString());
    }
  }

  @Override
  public List<Entrega> findAll() {
    return repository.findAll();
  }

  @Override
  public void update(Long id, EntregaDto object) {
    try {
      Entrega toUpdate = repository.findById(id).get();
      toUpdate.setStatus(object.getStatus());
      repository.save(toUpdate);
    } catch (Exception e) {
      throw new EntregaNaoEncontradaException(id.toString());
    }
  }

  @Override
  public void delete(Long id) {
    try {
      repository.deleteById(id);
    } catch (Exception e) {
      throw new EntregaNaoEncontradaException(id.toString());
    }


  }


}
