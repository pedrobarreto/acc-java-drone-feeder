package com.aceleracaojava.dronefeeder.service;

import java.util.List;

/**
 * ServiceInterface.
 */
public interface ServiceInterface<T, K> {
  public K create(T object);

  public K findById(Long id);

  public List<K> findAll();

  public void update(Long id, T object);

  public void delete(Long id);

}
