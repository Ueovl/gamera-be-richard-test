package com.avengers.gamera.dto.genre;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GenrePostDto {
    @NotNull
    private String name;
}
