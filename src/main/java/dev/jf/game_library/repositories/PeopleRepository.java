package dev.jf.game_library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jf.game_library.models.Person;

import java.util.Set;

import dev.jf.game_library.models.Game;
import dev.jf.game_library.models.GamePeople;


@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>{

    List<Person> findByGamesWorkedOn(Set<GamePeople> gamesWorkedOn);
    List<Person> findByGamesWorkedOn(Game game);
    List<Person> findByNationality(String nationality);
}
