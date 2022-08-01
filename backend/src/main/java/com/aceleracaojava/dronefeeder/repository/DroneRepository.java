package com.aceleracaojava.dronefeeder.repository;

import com.aceleracaojava.dronefeeder.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DroneRepository.
 */
@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

}
