CREATE TABLE "game" (
    "id" BIGSERIAL PRIMARY KEY,
	"name" VARCHAR(255) NOT NULL,
    "platform" VARCHAR(50),
	"release_date" DATE,
    "country" VARCHAR(50),
	"scores" NUMERIC(3,1),
	"developers" VARCHAR(255),
	"publishers" VARCHAR(255),
	"introduction" VARCHAR(1000),
	"description" TEXT,
	"is_deleted" BOOLEAN DEFAULT FALSE NOT NULL,
	"created_time" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "updated_time" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);