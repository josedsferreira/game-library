package dev.jf.game_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jf.game_library.models.GamePeople;
import dev.jf.game_library.models.GamePeopleKey;

import java.util.List;

import dev.jf.game_library.models.Game;


@Repository
public interface GamePeopleRepository extends JpaRepository<GamePeople, GamePeopleKey>{

    List<GamePeople> findByGame(Game game);
    List<GamePeople> findByJobRole(String jobRole);
}

