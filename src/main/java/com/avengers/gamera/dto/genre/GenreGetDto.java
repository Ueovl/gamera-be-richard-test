package com.avengers.gamera.dto.genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GenreGetDto {
    private Long id;
    private String name;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
