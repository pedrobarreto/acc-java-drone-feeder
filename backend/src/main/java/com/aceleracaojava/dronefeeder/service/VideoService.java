package com.aceleracaojava.dronefeeder.service;

import com.aceleracaojava.dronefeeder.dto.VideoDto;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.entity.Video;
import com.aceleracaojava.dronefeeder.repository.EntregaRepository;
import com.aceleracaojava.dronefeeder.repository.VideoRepository;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * VideoService.
 */
@Service
public class VideoService {

  @Autowired
  private VideoRepository repository;

  @Autowired
  private EntregaRepository entregaRepo;

  /**
   * Método save.
   */
  public void save(MultipartFile file, Long entregaId) throws IOException {
    Video newVideo = new Video();
    newVideo.setNomeArquivo(file.getOriginalFilename());
    newVideo.setDados(file.getBytes());
    Entrega entrega = entregaRepo.findById(entregaId).get();
    entrega.setVideo(newVideo);
    entregaRepo.save(entrega);
  }

  public Video getVideoById(Long id) {
    return repository.findById(id).get();
  }

  /**
   * Método getVideos.
   */
  public List<VideoDto> getVideos() {
    var videos = repository.findAll();
    return videos.stream().map(video -> new VideoDto(video.getId(), video.getNomeArquivo()))
        .collect(Collectors.toList());
  }

}
