package com.avengers.gamera.dto.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class GameUpdateDto {
    @NotNull
    private Long id;
    private String name;
    private String platform;
    private Date releaseDate;
    private String country;
    private Double scores;
    private String developers;
    private String publishers;
    private String introduction;
    private String description;
}
