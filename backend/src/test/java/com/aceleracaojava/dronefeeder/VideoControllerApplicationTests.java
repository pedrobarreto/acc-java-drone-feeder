package com.aceleracaojava.dronefeeder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.aceleracaojava.dronefeeder.entity.Drone;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.repository.DroneRepository;
import com.aceleracaojava.dronefeeder.repository.EntregaRepository;
import com.aceleracaojava.dronefeeder.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class VideoControllerApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private EntregaRepository entregaRepository;

  @Autowired
  private VideoRepository videoRepository;
  @Autowired
  private DroneRepository droneRepository;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @BeforeEach
  public void setup() {
    droneRepository.deleteAll();
    entregaRepository.deleteAll();
    videoRepository.deleteAll();
  }

  //https://www.baeldung.com/spring-multipart-post-request-test
  @Test
  @Order(1)
  @DisplayName("1 - Salva um video com sucesso")
  void salvarVideoComSucesso() throws Exception {

    final Drone drone = new Drone();
    drone.setNome("Drone 1");
    droneRepository.save(drone);
    final Entrega entrega = new Entrega();
    entrega.setDrone(drone);

    entregaRepository.save(entrega);

    MockMultipartFile file = new MockMultipartFile(
        "video",
        "video.mp4",
        MediaType.APPLICATION_OCTET_STREAM_VALUE,
        "content".getBytes()
    );

    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    mockMvc.perform(multipart("/videos").file(file).param("entregaId", entrega.getId().toString()))
        .andExpect(status().isCreated())
        .andExpect(content().string("Video salvo com sucesso"));
  }


  @Test
  @Order(2)
  @DisplayName("2 - Deve retornar lista Vazia quando não houver nenhum video cadastrado.")
  void listaTodosOsVideos() throws Exception {
    mockMvc.perform(get("/videos"))
        .andExpect(status().isOk())
        .andExpect(content().string("[]"));
  }


}
