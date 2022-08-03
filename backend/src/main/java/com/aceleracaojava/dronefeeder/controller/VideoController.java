package com.aceleracaojava.dronefeeder.controller;

import com.aceleracaojava.dronefeeder.dto.VideoDto;
import com.aceleracaojava.dronefeeder.entity.Video;
import com.aceleracaojava.dronefeeder.service.VideoService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * VideoController.
 */
@CrossOrigin
@RestController
@RequestMapping("/videos")
public class VideoController {

  @Autowired
  private VideoService service;

  /**
   * Método save.
   */
  @PostMapping
  public ResponseEntity<String> save(@RequestParam("video") MultipartFile video,
      @RequestParam("entregaId") Long entregaId) throws IOException {
    service.save(video, entregaId);
    return ResponseEntity.status(HttpStatus.CREATED).body("Video salvo com sucesso");

  }

  /**
   * Método downloadVideo.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Resource> downloadVideo(@PathVariable Long id) {
    // Load file from database
    Video video = service.getVideoById(id);

    return ResponseEntity.ok().contentType(MediaType.parseMediaType("video/mp4"))
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + video.getNomeArquivo() + "\"")
        .body(new ByteArrayResource(video.getDados()));
  }

  @GetMapping
  public List<VideoDto> getVideosUri() {
    return service.getVideos();
  }



}
