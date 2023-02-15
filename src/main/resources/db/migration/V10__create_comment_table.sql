CREATE TABLE "comment" (
    "id" BIGSERIAL PRIMARY KEY,
    "parent_id" BIGINT,
    CONSTRAINT fk_comment_comment
        FOREIGN KEY (parent_id)
        REFERENCES "comment"(id),
    "text" VARCHAR(800) NOT NULL,
    "is_deleted" BOOLEAN DEFAULT FALSE NOT NULL,
    "author_id" BIGINT NOT NULL,
    CONSTRAINT fk_user_comment
        FOREIGN KEY (author_id)
        REFERENCES "user"(id),
    "article_id" BIGINT NOT NULL,
    CONSTRAINT fk_article_comment
        FOREIGN KEY (article_id)
        REFERENCES "article"(id),
    "created_time" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "updated_time" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);
