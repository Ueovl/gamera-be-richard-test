package com.avengers.gamera.contoller;

import com.avengers.gamera.dto.game.GamePostDto;
import com.avengers.gamera.dto.game.GameUpdateDto;
import com.avengers.gamera.repository.GameRepository;
import com.avengers.gamera.service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.time.Instant;
import java.util.Date;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    private GamePostDto mockGamePostDto;

    private GameUpdateDto mockGameUpdateDto;

    private Long mockGameId;

    @BeforeEach
    void clean() {
        gameRepository.deleteAll();
        gameRepository.flush();
        mockGamePostDto = GamePostDto.builder()
                .name("Au")
                .build();
        Date releaseDate = Date.from(Instant.ofEpochSecond(2022-3-29));

        mockGameUpdateDto = GameUpdateDto.builder().name("Cn").country("d").description("ss").platform("DD")
                .publishers("dd").scores(2.3).releaseDate(releaseDate).introduction("sdd").developers("hh").build();

        mockGameId = gameService.createGame(GamePostDto.builder().name("any").country("Au").build()).getId();
    }

    @Test
    void shouldReturn201AndGameGetDtoWhenCreateGame() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockGamePostDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Au"));
    }

    @Test
    void shouldReturn200AndGameGetDtoWhenGetGameDto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/games/" + mockGameId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("any"));
    }

    @Test
    void shouldReturnUpdatedGameGetDtoWhenUpdateDto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/games/" + mockGameId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mockGameUpdateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Cn"));

    }

    @Test
    public void shouldDeleteGameWhenDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/games/{id}", mockGameId))
                .andExpect(status().isOk());
    }

}
