package com.aceleracaojava.dronefeeder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.aceleracaojava.dronefeeder.entity.Drone;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.repository.DroneRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

  }

  @Test
  @Order(2)
  @DisplayName("2 - Deve retornar um erro ao buscar um drone que não existe.")
  void buscaDroneQueNaoExiste() throws Exception {
    mockMvc.perform(get("/drones/8"))
        .andExpect(status().isNotFound())
        .andExpect(content().string("Nenhum drone encontrado com o id: 8"));
  }

  @Test
  @Order(3)
  @DisplayName("3 - Deve deletar um drone com sucesso.")
    void deletaDroneComSucesso() throws Exception {
    Drone drone = new Drone();
    drone.setNome("Drone");
    droneRepository.save(drone);
        mockMvc.perform(delete("/drones/" + drone.getId()))
            .andExpect(status().isNoContent());
    }

    @Test
    @Order(4)
    @DisplayName("4 - Deve retornar um erro ao deletar um drone que não existe.")
    void deletaDroneQueNaoExiste() throws Exception {
        mockMvc.perform(delete("/drones/99"))
            .andExpect(status().isNotFound())
            .andExpect(content().string("Nenhum drone encontrado com o id: 99"));
    }

    @Test
    @Order(5)
    @DisplayName("5 - Deve alterar um drone com sucesso.")
    void alteraDroneComSucesso() throws Exception {
      Drone drone = new Drone();
      drone.setNome("Drone");
      droneRepository.save(drone);
      drone.setNome("Drone Alterado");
      mockMvc.perform(patch("/drones/" + drone.getId())
              .contentType(MediaType.APPLICATION_JSON)
              .content(new ObjectMapper().writeValueAsString(drone)))
          .andExpect(status().isNoContent());
    }

    @Test
    @Order(6)
    @DisplayName("6 - Deve retornar lista Vazia quando não houver nenhum drone cadastrado.")
    void listaTodosOsDrones() throws Exception {
      mockMvc.perform(get("/drones"))
          .andExpect(status().isOk())
          .andExpect(content().string("[]"));
    }

    @Test
    @Order(7)
    @DisplayName("7 - Deve trazer as entregas de um drone buscado.")
    void buscaEntregasDeDrone() throws Exception {
      Drone drone = new Drone();
      drone.setNome("Drone");
      droneRepository.save(drone);

      Entrega entrega = new Entrega();
      entrega.setDrone(drone);
      mockMvc.perform(get("/drones/" + drone.getId() + "/entregas"))
      .andExpect(status().isOk());
  }
}
