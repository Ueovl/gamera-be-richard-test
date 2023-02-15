CREATE TABLE "user_likes_article"(
    "user_id" BIGINT,
    CONSTRAINT fk_user_user_likes_article
        FOREIGN KEY (user_id)
        REFERENCES "user"(id),
    "article_id" BIGINT,
    CONSTRAINT fk_article_user_likes_article
        FOREIGN KEY (article_id)
        REFERENCES "article"(id),
    PRIMARY KEY (user_id, article_id),
    "created_time" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);