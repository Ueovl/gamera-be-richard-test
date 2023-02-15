CREATE TABLE "article" (
    "id" BIGSERIAL PRIMARY KEY,
	"game_id" BIGINT,
	CONSTRAINT fk_game_article
        FOREIGN KEY(game_id)
        REFERENCES "game"(id),
	"author_id" BIGINT,
	CONSTRAINT fk_user_article
        FOREIGN KEY(author_id)
        REFERENCES "user"(id),
    "cover_img_url" VARCHAR(255) NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "text" TEXT NOT NULL,
    "type" VARCHAR(20) NOT NULL,
    "is_deleted" BOOLEAN DEFAULT FALSE NOT NULL,
    "created_time" TIMESTAMP WITH TIME ZONE NOT NULL,
    "updated_time" TIMESTAMP WITH TIME ZONE NOT NULL
);