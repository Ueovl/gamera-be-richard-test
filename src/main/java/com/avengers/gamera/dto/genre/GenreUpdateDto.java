package com.avengers.gamera.dto.genre;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GenreUpdateDto {
    @NotNull
    private String name;
}
