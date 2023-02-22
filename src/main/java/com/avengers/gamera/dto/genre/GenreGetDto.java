package com.avengers.gamera.dto.genre;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreGetDto {
    private Long id;
    private String name;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
