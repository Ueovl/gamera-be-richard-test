package com.avengers.gamera.service;

import com.avengers.gamera.dto.game.GameGetDto;
import com.avengers.gamera.dto.game.GamePostDto;
import com.avengers.gamera.dto.game.GameUpdateDto;
import com.avengers.gamera.entity.Game;
import com.avengers.gamera.exception.ResourceExistException;
import com.avengers.gamera.exception.ResourceNotFoundException;
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

    public GameGetDto getGame(Long id) {
        Game game =gameRepository.findGameByIdAndIs_deleted(id, false).orElseThrow(()->new ResourceNotFoundException("game"));
        return gameMapper.GameToGameGetDto(game);
    }

    public GameGetDto updateGame(GameUpdateDto gameUpdateDto) {
        Game game=gameRepository.findGameByIdAndIs_deleted(gameUpdateDto.getId(), false).orElseThrow(()->new ResourceNotFoundException("game"));
        game.setName(gameUpdateDto.getName());
        game.setPlatform(gameUpdateDto.getPlatform());
        game.setRelease_date(gameUpdateDto.getRelease_date());
        game.setCountry(gameUpdateDto.getCountry());
        game.setScores(gameUpdateDto.getScores());
        game.setDevelopers(gameUpdateDto.getDevelopers());
        game.setPublishers(gameUpdateDto.getPublishers());
        game.setIntroduction(gameUpdateDto.getIntroduction());
        game.setDescription(gameUpdateDto.getDescription());

        return gameMapper.GameToGameGetDto(gameRepository.save((game)));
    }

    public String deleteGame(Long id) {
        Game game=gameRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("game"));
        game.setIs_deleted(true);
        gameRepository.save(game);
        return "Delete game successfully";
    }
}
