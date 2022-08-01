package com.aceleracaojava.dronefeeder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.aceleracaojava.dronefeeder.entity.Drone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class DroneFeederApplicationTests {

  @Autowired
  private MockMvc mockMvc;


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

}
