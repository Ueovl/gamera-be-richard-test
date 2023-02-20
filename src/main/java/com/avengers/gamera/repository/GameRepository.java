package com.avengers.gamera.repository;

import com.avengers.gamera.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Boolean existsUserByName (String name);

    @Query("SELECT u FROM Game u WHERE u.id = ?1 and u.isDeleted = ?2")
    Optional<Game> findGameByIdAndIsDeleted(Long id, Boolean isDeleted);

}
