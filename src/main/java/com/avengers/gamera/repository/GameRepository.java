package com.avengers.gamera.repository;

import com.avengers.gamera.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    Boolean existsUserByName (String name);

}
