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

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@Service
public class GameService {
    public final GameRepository gameRepository;
    public final GameMapper gameMapper;

    public GameGetDto createGame(GamePostDto gamePostDto) {
        Game game = gameMapper.GamePostDtoToGame(gamePostDto);
        isExist(game.getName());
        return gameMapper.GameToGameGetDto(gameRepository.save(game));
    }

    public boolean isExist(String name) {

        Boolean isExist = gameRepository.existsUserByName(name);
        if (Boolean.TRUE.equals(isExist)) {
            throw new ResourceExistException("Game already existed!");
        }
        return isExist;
    }

    public GameGetDto getGame(Long id) {
        return gameMapper.GameToGameGetDto(findActiveGame(id));
    }

    public GameGetDto updateGame(GameUpdateDto gameUpdateDto, Long id) {
        Game game = findActiveGame(id);
        gameUpdateDto.setCreatedTime(game.getCreatedTime());
        gameUpdateDto.setId(id);
        gameUpdateDto.setIsDeleted(game.getIsDeleted());
        gameUpdateDto.setUpdatedTime(OffsetDateTime.now());
        gameMapper.GameUpdateDtoToGame(gameUpdateDto);

        return gameMapper.GameToGameGetDto(gameRepository.save((gameMapper.GameUpdateDtoToGame(gameUpdateDto))));
    }

    public String deleteGame(Long id) {
        Game game = findActiveGame(id);
        game.setIsDeleted(true);
        gameRepository.save(game);
        return "Delete game successfully";
    }

    public Game findActiveGame(Long id) {
        return gameRepository.findGameByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("game"));
    }
}
