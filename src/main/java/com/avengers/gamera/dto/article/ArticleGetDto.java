package com.avengers.gamera.dto.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleGetDto {
    private Long id;
    private String coverImgUrl;
    private String title;
    private String text;
    private String type;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
