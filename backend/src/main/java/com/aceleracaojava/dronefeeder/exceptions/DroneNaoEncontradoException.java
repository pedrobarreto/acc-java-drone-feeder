package com.aceleracaojava.dronefeeder.exceptions;

/**
 * DroneNaoEncontradoException.
 */
public class DroneNaoEncontradoException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new Drone nao encontrado exception.
   *
   * @param message the message
   */
  public DroneNaoEncontradoException(String message) {
    super("Nenhum drone encontrado com o id: " + message);
  }

}
