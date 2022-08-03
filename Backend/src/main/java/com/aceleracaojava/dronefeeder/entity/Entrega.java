package com.aceleracaojava.dronefeeder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



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

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "drone_id")
  private Drone drone;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "video_id")
  @JsonIgnore
  private Video video;

  @Column(name = "video_id", insertable = false, updatable = false)
  private Long videoId;

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


  public Drone getDrone() {
    return drone;
  }

  public void setDrone(Drone drone) {
    this.drone = drone;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    video.setEntrega(this);
    this.video = video;
  }

  public Long getVideoId() {
    return videoId;
  }

  public void setVideoId(Long videoId) {
    this.videoId = videoId;
  }



}
