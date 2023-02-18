package com.avengers.gamera.service;

import com.avengers.gamera.dto.game.GameGetDto;
import com.avengers.gamera.dto.game.GamePostDto;
import com.avengers.gamera.entity.Game;
import com.avengers.gamera.exception.ResourceExistException;
import com.avengers.gamera.mapper.GameMapper;
import com.avengers.gamera.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameService {
    public final GameRepository gameRepository;
    public final GameMapper gameMapper;

    public GameGetDto createGame(GamePostDto gamePostDto) {
        Game game=gameMapper.GamePostDtoToGame(gamePostDto);
        isExist(game.getName());
        return gameMapper.GameToGameGetDto(gameRepository.save(game));
    }

    public boolean isExist (String name){
        Boolean isExist= gameRepository.existsUserByName(name);
        if (Boolean.TRUE.equals(isExist)) {
            throw new ResourceExistException("Game already existed!");
        }
        return isExist;
    }
}
