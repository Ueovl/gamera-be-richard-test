CREATE TABLE "game_genre"(
    "id" BIGSERIAL PRIMARY KEY,
    "game_id" BIGINT,
     CONSTRAINT fk_game_game_genre
        FOREIGN KEY(game_id)
        REFERENCES "game"(id),
    "genre_id" BIGINT,
     CONSTRAINT fk_genre_game_genre
        FOREIGN KEY(genre_id)
        REFERENCES "genre"(id)
);