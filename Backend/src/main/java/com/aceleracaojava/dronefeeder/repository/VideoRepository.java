package com.aceleracaojava.dronefeeder.repository;

import com.aceleracaojava.dronefeeder.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * VideoRepository.
 */
@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

}
