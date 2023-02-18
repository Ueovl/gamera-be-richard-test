package com.avengers.gamera.controller;

import com.avengers.gamera.dto.game.GameGetDto;
import com.avengers.gamera.dto.game.GamePostDto;
import com.avengers.gamera.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("games")
public class GameController {
    public final GameService gameService;

    @PostMapping
    public GameGetDto createGame (@Valid @RequestBody GamePostDto gamePostDto){
        return gameService.createGame(gamePostDto);
    }
}
