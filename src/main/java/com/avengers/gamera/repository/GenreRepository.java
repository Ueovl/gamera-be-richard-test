package com.avengers.gamera.repository;

import com.avengers.gamera.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Boolean existsGenresByName(String name);

    @Override
    List<Genre> findAllById(Iterable<Long> longs);
}
