package com.aceleracaojava.dronefeeder.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 * Entity Video.
 */
@Entity
public class Video {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nomeArquivo;

  @Lob
  private byte[] dados;

  @OneToOne(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true,
      fetch = FetchType.LAZY)
  private Entrega entrega;

  public Video() {
    // TODO Auto-generated constructor stub
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

  public byte[] getDados() {
    return dados;
  }

  public void setDados(byte[] dados) {
    this.dados = dados;
  }

  public Entrega getEntrega() {
    return entrega;
  }

  public void setEntrega(Entrega entrega) {
    this.entrega = entrega;
  }

}