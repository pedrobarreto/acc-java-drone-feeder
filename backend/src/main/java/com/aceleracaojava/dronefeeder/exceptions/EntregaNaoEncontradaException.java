package com.aceleracaojava.dronefeeder.exceptions;

/**
 * The type Entrega nao encontrada exception.
 */
public class EntregaNaoEncontradaException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new Entrega nao encontrada exception.
   *
   * @param message the message
   */
  public EntregaNaoEncontradaException(String message) {
    super("Nenhuma entrega encontrada com o id: " + message);
  }

}
