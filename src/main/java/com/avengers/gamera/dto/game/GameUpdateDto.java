package com.avengers.gamera.dto.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class GameUpdateDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String platform;

    @NotNull
    private Date releaseDate;

    @NotNull
    private String country;
    private Boolean isDeleted;

    @NotNull
    private Double scores;

    @NotNull
    private String developers;

    @NotNull
    private String publishers;

    @NotNull
    private String introduction;

    @NotNull
    private String description;

    private OffsetDateTime createdTime;

    private OffsetDateTime updatedTime;

}
