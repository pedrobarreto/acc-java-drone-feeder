package com.aceleracaojava.dronefeeder.entity;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity Entrega.
 */
@Entity
public class Entrega {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String status = "pendente";

  @Column
  private String data = Instant.now().toString();

  @Column
  private String arquivoVideo;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "drone_id")
  private Drone drone;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getArquivo_video() {
    return arquivoVideo;
  }

  public void setArquivo_video(String arquivoVideo) {
    this.arquivoVideo = arquivoVideo;
  }

  public Drone getDrone() {
    return drone;
  }

  public void setDrone(Drone drone) {
    this.drone = drone;
  }


}
