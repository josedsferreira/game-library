-- Add Companies (Developer and Publisher)
INSERT INTO company (company_name, country_origin, company_type) 
VALUES ('Team Silent', 'Japan', 'developer'), 
       ('Konami', 'Japan', 'publisher'),
       ('Capcom', 'Japan', 'publisher/developer');

-- Add People (Director, Producer, etc.)
INSERT INTO person (person_name, nationality, gender, birth_date)
VALUES ('Keiichiro Toyama', 'Japanese', 'male', '1970-08-01'),
       ('Gozo Kitao', 'Japanese', 'male', NULL),
       ('Akihiro Imamura', 'Japanese', 'male', NULL),
       ('Akira Yamaoka', 'Japanese', 'male', '1968-02-06'),
       ('Shinji Mikami', 'Japanese', 'male', '1965-08-11');

-- Add Series
INSERT INTO series (series_name) 
VALUES ('Silent Hill'), 
       ('Resident Evil');

-- Add Platforms
INSERT INTO platform (platform_name, platform_abreviation, manufacturer, product_family, platform_release_date_NA, platform_release_date_JP, platform_release_date_EU, platform_type, generation) 
VALUES ('PlayStation', 'PS1', 2, 'PlayStation', '1995-09-09', '1994-12-03', '1995-09-29', 'console', 5),
       ('PC', 'PC', NULL, 'PC', NULL, NULL, NULL, 'home computer', NULL);

-- Add Genres
INSERT INTO genre (genre_name)
VALUES ('Survival horror'), 
       ('Action adventure');

-- Add Games
INSERT INTO game (title, developer_studio, publisher, director, game_series) 
VALUES ('Silent Hill', 1, 2, 1, 1), 
       ('Resident Evil', 1, 3, 3, 2);

-- Link People to Games with Roles
INSERT INTO game_people (game_id, person_id, job_role)
VALUES (1, 1, 'Director'),
       (1, 2, 'Producer'),
       (1, 3, 'Programmer'),
       (1, 4, 'Composer'),
       (2, 5, 'Director');

-- Link Games to Platforms with Regional Release Dates
INSERT INTO game_platforms (game_id, platform_id, release_date_NA, release_date_JP, release_date_EU)
VALUES (1, 1, '1999-02-24', '1999-03-04', '1999-07-16'),
       (2, 1, '1996-03-30', '1996-03-22', '1996-08-01'),
       (2, 2, '1996-03-30', '1996-03-22', '1996-08-01');

-- Link Games to Genres
INSERT INTO game_genres (game_id, genre_id)
VALUES (1, 1), 
       (2, 1);

