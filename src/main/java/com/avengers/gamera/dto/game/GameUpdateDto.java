package com.avengers.gamera.dto.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class GameUpdateDto {
    private Long id;
    private String name;
    private String platform;
    private Date release_date;
    private String country;
    private Integer scores;
    private String developers;
    private String publishers;
    private String introduction;
    private String description;
}
