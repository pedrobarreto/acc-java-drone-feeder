package com.aceleracaojava.dronefeeder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.aceleracaojava.dronefeeder.entity.Drone;
import com.aceleracaojava.dronefeeder.repository.DroneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class DroneFeederApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private DroneRepository droneRepository;

  @BeforeEach
  public void setup() {
    droneRepository.deleteAll();
  }


  @Test
  @Order(1)
  @DisplayName("1 -  Deve adicionar um drone com sucesso no banco de dados.")
  void adicionaDroneComSucesso() throws Exception {
    final Drone drone = new Drone();
    drone.setNome("Drone 1");
    drone.setStatus("Disponível");
    drone.setLatitude(23.5);
    drone.setLongitude(25.5);

    mockMvc.perform(post("/drones")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(drone)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

  }

  @Test
  @Order(2)
  @DisplayName("2 - Deve retornar um erro ao buscar um drone que não existe.")
  void buscaDroneQueNaoExiste() throws Exception {
    mockMvc.perform(get("/drones/8"))
        .andExpect(status().isNotFound())
        .andExpect(content().string("Nenhum drone encontrado com o id: 8"));
  }


}
