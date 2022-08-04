package com.aceleracaojava.dronefeeder.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * ControllerInterface.
 */
public interface ControllerInterface<T, K> {
  public ResponseEntity<K> create(T object);

  public K findById(Long id);

  public List<K> findAll();

  public ResponseEntity<Object> update(Long id, T object);

  public ResponseEntity<Object> delete(Long id);

}
