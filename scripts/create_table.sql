
CREATE TABLE "SIMPLETIMETRACKER"."database_entries" ("user_id" INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1),
                                                     "date_creation" VARCHAR(50) DEFAULT NULL,"time" VARCHAR(25) DEFAULT NULL,
                                                     "category" VARCHAR(50) DEFAULT NULL,"note" CLOB(2K) DEFAULT NULL);