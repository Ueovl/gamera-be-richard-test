package com.avengers.gamera.dto.article;

import com.avengers.gamera.constant.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleGetDto {
    private Long id;
    private String coverImgUrl;
    private String title;
    private String text;
    private ArticleType type;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
