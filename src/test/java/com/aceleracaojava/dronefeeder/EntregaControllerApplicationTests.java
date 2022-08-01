package com.aceleracaojava.dronefeeder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.aceleracaojava.dronefeeder.entity.Drone;
import com.aceleracaojava.dronefeeder.entity.Entrega;
import com.aceleracaojava.dronefeeder.repository.DroneRepository;
import com.aceleracaojava.dronefeeder.repository.EntregaRepository;
import java.util.HashMap;
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
class EntregaControllerApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private EntregaRepository entregaRepository;

  @BeforeEach
  public void setup() {
    entregaRepository.deleteAll();
  }


  @Test
  @Order(1)
  @DisplayName("2 - Deve retornar um erro ao buscar uma entrega que não existe.")
  void buscaEntregaQueNaoExiste() throws Exception {
    mockMvc.perform(get("/entregas/99"))
        .andExpect(status().isNotFound())
        .andExpect(content().string("Nenhuma entrega encontrada com o id: 99"));
  }

}
