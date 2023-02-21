package com.avengers.gamera.contoller;

import com.avengers.gamera.controller.GameController;
import com.avengers.gamera.dto.game.GamePostDto;
import com.avengers.gamera.mapper.GameMapper;
import com.avengers.gamera.repository.GameRepository;
import com.avengers.gamera.service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private  GameService gameService;

    @Autowired
    private GameController gameController;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameMapper gameMapper;

    private GamePostDto mockGgamePostDto;

    private Long mockGameId;

    @BeforeEach
    void clean(){
        gameRepository.deleteAll();
        gameRepository.flush();
        mockGgamePostDto = GamePostDto.builder()
                .name("Au")
                .build();

        mockGameId = gameService.createGame(mockGgamePostDto).getId();
    }


}
