
DROP SCHEMA IF EXISTS "electronics_game" CASCADE;
CREATE SCHEMA "electronics_game";


-----------------------------------------------------------------------------------------------------------------------
-- designs
-----------------------------------------------------------------------------------------------------------------------

CREATE TABLE "electronics_game"."Design" (
	"id" bigserial NOT NULL PRIMARY KEY
);

CREATE TABLE "electronics_game"."DesignPart" (
	"id" bigserial NOT NULL PRIMARY KEY,
	"designId" bigint NOT NULL REFERENCES "electronics_game"."Design" ON DELETE CASCADE,
    "partType" text NOT NULL,
    "x" integer NOT NULL,
    "y" integer NOT NULL,
    "configuration" jsonb NOT NULL
);
CREATE INDEX "DesignPart_designIdIndex" ON "electronics_game"."DesignPart" ("designId");



-----------------------------------------------------------------------------------------------------------------------
-- players
-----------------------------------------------------------------------------------------------------------------------

CREATE TABLE "electronics_game"."Player" (
	"id" bigserial NOT NULL PRIMARY KEY,
	"name" character varying(500) NOT NULL CHECK ("name" != ''),
	"loginToken" character varying(500) CHECK (LENGTH("loginToken") > 10), -- TODO include (IS NULL OR) in the check?
	"emailAddress" character varying(500) CHECK (LENGTH("loginToken") >= 5)
);
CREATE INDEX "Player_nameIndex" ON "electronics_game"."Player" ("name");
CREATE UNIQUE INDEX "Player_loginToken" ON "electronics_game"."Player" ("loginToken");
CREATE INDEX "Player_emailAddress" ON "electronics_game"."Player" ("emailAddress");



-----------------------------------------------------------------------------------------------------------------------
-- peripherals
-----------------------------------------------------------------------------------------------------------------------

CREATE TABLE "electronics_game"."GameFeedback" (
	"id" bigserial NOT NULL PRIMARY KEY,
	"timestamp" timestamp with time zone NOT NULL DEFAUlT NOW(),
	"sessionId" character varying(1000),
	"playerId" bigint REFERENCES "electronics_game"."Player" ON DELETE SET NULL,
	"context" jsonb NOT NULL, -- but may be JSON null to indicate no / unknown context
	"text" text NOT NULL
);

-----------------------------------------------------------------------------------------------------------------------
-- more foreign keys which could not be defined above due to table creation order, or because they are circular
-----------------------------------------------------------------------------------------------------------------------

-- ALTER TABLE "electronics_game"."whatever" ADD FOREIGN KEY ("playerId") REFERENCES "electronics_game"."Player";

-----------------------------------------------------------------------------------------------------------------------
-- test data
-----------------------------------------------------------------------------------------------------------------------

INSERT INTO "electronics_game"."Design" DEFAULT VALUES;
