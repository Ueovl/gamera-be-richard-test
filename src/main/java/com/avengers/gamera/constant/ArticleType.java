package com.avengers.gamera.constant;

import java.util.Objects;
import java.util.stream.Stream;

public enum ArticleType {
    NEWS("news"),
    REVIEWS("reviews");

    private final String typeName;

    ArticleType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public static ArticleType of(String name) {
        return Stream.of(ArticleType.values())
                .filter(p -> Objects.equals(p.getTypeName(), name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
