package com.aceleracaojava.dronefeeder.controller;

import java.util.List;

/**
 * ControllerInterface.
 */
public interface ControllerInterface<T, K> {
  public K create(T object);

  public K findById(Long id);

  public List<K> findAll();

  public void update(Long id, T object);

  public void delete(Long id);

}
