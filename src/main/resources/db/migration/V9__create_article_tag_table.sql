CREATE TABLE "article_tag"(
    "article_id" BIGINT,
    CONSTRAINT fk_article_article_tag
        FOREIGN KEY(article_id)
        REFERENCES "article"(id),
    "tag_id" BIGINT,
    CONSTRAINT fk_tag_article_tag
        FOREIGN KEY(tag_id)
        REFERENCES "tag"(id),
    PRIMARY KEY (article_id, tag_id)
);