package com.aceleracaojava.dronefeeder.dto;

/**
 * VideoDto.
 */
public class VideoDto {

  private Long id;

  private String nomeArquivo;

  /**
   * Construtor.
   */
  public VideoDto(Long id, String nome) {
    // TODO Auto-generated constructor stub
    this.id = id;
    this.nomeArquivo = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeArquivo() {
    return nomeArquivo;
  }

  public void setNomeArquivo(String nomeArquivo) {
    this.nomeArquivo = nomeArquivo;
  }



}