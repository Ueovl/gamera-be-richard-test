package com.avengers.gamera.service;

import com.avengers.gamera.dto.genre.GenreGetDto;
import com.avengers.gamera.dto.genre.GenrePostDto;
import com.avengers.gamera.dto.genre.GenreUpdateDto;
import com.avengers.gamera.entity.Genre;
import com.avengers.gamera.exception.ResourceNotFoundException;
import com.avengers.gamera.mapper.GenreMapper;
import com.avengers.gamera.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenreGetDto createGenre(GenrePostDto genrePostDto) {
        Genre genre = genreMapper.GenrePostDtoToGenre(genrePostDto);
        return genreMapper.GenreToGenreGetDto(genreRepository.save(genre));
    }

    public GenreGetDto getGenre(Long id) {
        Genre genre = findGenre(id);
        return genreMapper.GenreToGenreGetDto(genre);
    }

    public GenreGetDto updateGe(GenreUpdateDto genreUpdateDto, Long id) {
        Genre genre = findGenre(id);
        genre.setName(genreUpdateDto.getName());
        genreRepository.save(genre);

        return genreMapper.GenreToGenreGetDto(genre);
    }

    public Genre findGenre(Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre"));
    }

}
