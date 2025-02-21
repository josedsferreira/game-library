/*

Developer(s)	Team Silent[a]
Publisher(s)	Konami
Director(s)	Keiichiro Toyama
Producer(s)	Gozo Kitao
Programmer(s)	Akihiro Imamura
Writer(s)	Keiichiro Toyama
Composer(s)	Akira Yamaoka
Series	Silent Hill
Platform(s)	PlayStation
Release	
NA: February 24, 1999[1]
JP: March 4, 1999
EU: July 16, 1999[2]
Genre(s)	Survival horror
Mode(s)	Single-player

*/


CREATE TYPE gender AS ENUM ('male', 'female', 'other');


CREATE TABLE IF NOT EXISTS person (
    person_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    person_name VARCHAR(255),
    nationality VARCHAR(255),
    gender gender,
    birth_date DATE
);

CREATE TABLE IF NOT EXISTS company (
    company_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    company_name VARCHAR(255) UNIQUE NOT NULL,
    country_origin VARCHAR(255),
    company_type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS series (
    series_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    series_name VARCHAR(255) UNIQUE NOT NULL
);

create TABLE IF NOT EXISTS game (
    game_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title VARCHAR(255) NOT NULL,
    developer_studio INT REFERENCES company(company_id) ON DELETE SET NULL,
    publisher INT REFERENCES company(company_id) ON DELETE SET NULL,
    director INT REFERENCES person(person_id) ON DELETE SET NULL,
    game_series INT REFERENCES series(series_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS game_people (
    game_id INT REFERENCES game(game_id) ON DELETE CASCADE,
    person_id INT REFERENCES person(person_id) ON DELETE CASCADE,
    job_role VARCHAR(50) NOT NULL,  -- role (e.g., director, writer, composer)
    PRIMARY KEY (game_id, person_id, job_role)
);

CREATE TABLE IF NOT EXISTS platform (
    platform_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    platform_name VARCHAR(255) UNIQUE NOT NULL,
    platform_abreviation VARCHAR(10),
    manufacturer INT REFERENCES company(company_id) ON DELETE SET NULL,
    product_family VARCHAR(255),
    platform_release_date_NA DATE,
    platform_release_date_JP DATE,
    platform_release_date_EU DATE,
    platform_type VARCHAR(255),
    generation INT
);

CREATE TABLE IF NOT EXISTS game_platforms (
    game_id INT REFERENCES game(game_id) ON DELETE CASCADE,
    platform_id INT REFERENCES platform(platform_id) ON DELETE CASCADE,
    release_date_NA DATE,
    release_date_JP DATE,
    release_date_EU DATE,
    PRIMARY KEY (game_id, platform_id)
);

CREATE TABLE IF NOT EXISTS genre (
    genre_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    genre_name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS game_genres (
    game_id INT REFERENCES game(game_id) ON DELETE CASCADE,
    genre_id INT REFERENCES genre(genre_id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, genre_id)
);

