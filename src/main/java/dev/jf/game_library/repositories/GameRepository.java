package dev.jf.game_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jf.game_library.models.Game;

import java.util.List;

import dev.jf.game_library.models.Person;
import dev.jf.game_library.models.Platform;
import dev.jf.game_library.models.Genre;

import java.util.Set;

import dev.jf.game_library.models.Company;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

    List<Game> findByDirector(Person director);
    List<Game> findByGenres(Set<Genre> genres);
    List<Game> findByGenres(Genre genre); // changing the arguments is ok
    List<Game> findByDeveloperStudio(Company developerStudio);
    List<Game> findByPlatforms(Platform platform);

}
