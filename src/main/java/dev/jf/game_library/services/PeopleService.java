package dev.jf.game_library.services;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.jf.game_library.models.Game;
import dev.jf.game_library.models.GamePeople;
import dev.jf.game_library.models.Person;
import dev.jf.game_library.repositories.PeopleRepository;

@Service
public class PeopleService {

    private final PeopleRepository repository;

    public PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    public Optional<Person> getPersonById(Integer id) {
        return repository.findById(id);
    }

    public List<Person> getAllPeople() {
        return repository.findAll();
    }

    public Person savePerson(Person person) {
        return repository.save(person);
    }

    public List<Person> getAllPeopleByGame(Set<GamePeople> gamesWorkedOn) {
        return repository.findByGamesWorkedOn(gamesWorkedOn);
    }

    public List<Person> getAllPeopleByGame(Game game) {
        return repository.findByGamesWorkedOn(game);
    }

    public List<Person> getAllPeopleByNationality(String nationality) {
        return repository.findByNationality(nationality);
    }
}
