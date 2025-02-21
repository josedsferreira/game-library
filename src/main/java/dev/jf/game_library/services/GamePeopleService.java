package dev.jf.game_library.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.jf.game_library.models.Game;
import dev.jf.game_library.models.GamePeople;
import dev.jf.game_library.repositories.GamePeopleRepository;

@Service
public class GamePeopleService {

    private final GamePeopleRepository repository;

    public GamePeopleService(GamePeopleRepository repository) {
        this.repository = repository;
    }

    public List<GamePeople> getAllGamePeople() {
        return repository.findAll();
    }

    public GamePeople saveGamePeople(GamePeople gamePerson) {
        return repository.save(gamePerson);
    }

    public List<GamePeople> getAllGamePeopleByGame(Game game) {
        return repository.findByGame(game);
    }

    public List<GamePeople> getAllGamePeopleByJobRole(String jobRole) {
        return repository.findByJobRole(jobRole);
    }

}
