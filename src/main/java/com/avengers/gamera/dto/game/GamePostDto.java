package com.avengers.gamera.dto.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class GamePostDto {

    @NotBlank
    @Size(max = 255, message = "Username can not be more than 255 characters.")
    private String name;

    @NotBlank
    private String platform;

    private Date release_date;

    @NotBlank
    private String country;

    private Integer scores;

    @NotBlank
    private String developers;

    @NotBlank
    private String publishers;

    @NotBlank
    private String introduction;

    @NotBlank
    private String description;

}
