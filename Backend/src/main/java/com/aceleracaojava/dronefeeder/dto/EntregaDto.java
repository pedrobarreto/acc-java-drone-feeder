package com.aceleracaojava.dronefeeder.dto;

/**
 * EntregaDto.
 */
public class EntregaDto {

  private String status;

  private String data;

  private Long droneId;

  private String arquivoVideo;

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

  public Long getDroneId() {
    return droneId;
  }

  public void setDroneId(Long droneId) {
    this.droneId = droneId;
  }

  public String getArquivoVideo() {
    return arquivoVideo;
  }

  public void setArquivoVideo(String arquivoVideo) {
    this.arquivoVideo = arquivoVideo;
  }


}
