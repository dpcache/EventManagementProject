

-- ----------------------------------------------
-- DDL Statements for tables
-- ----------------------------------------------

CREATE TABLE "GAMESUMMARY" ("ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "CLIENTGESTURE" VARCHAR(255), "SERVERGESTURE" VARCHAR(255), "RESULT" VARCHAR(255), "TIMEPLAYED" TIMESTAMP);
CREATE TABLE "EVENTS" ("ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "EVENTNAME" VARCHAR(255), "PERFORMER" VARCHAR(255), "PRICE" FLOAT(2), "TIMESTARTED" TIMESTAMP);
-- ----------------------------------------------
-- DDL Statements for keys
-- ----------------------------------------------

-- primary/unique
ALTER TABLE "EVENTS" ADD CONSTRAINT "SQL120325130144010" PRIMARY KEY ("ID");