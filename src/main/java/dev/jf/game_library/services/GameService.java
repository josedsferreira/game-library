package dev.jf.game_library.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dev.jf.game_library.models.Company;
import dev.jf.game_library.models.Game;
import dev.jf.game_library.models.Genre;
import dev.jf.game_library.models.Person;
import dev.jf.game_library.models.Platform;
import dev.jf.game_library.repositories.GameRepository;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Optional<Game> getGameById(Integer id) {
        return gameRepository.findById(id);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> getAllGamesByDirector (Person director) {
        return gameRepository.findByDirector(director);
    }

    public List<Game> getAllGamesInGenre (Set<Genre> genres) {
        return gameRepository.findByGenres(genres);
    }

    public List<Game> getAllGamesInGenre (Genre genre) {
        return gameRepository.findByGenres(genre);
    }

    public List<Game> getAllGamesByCompany (Company studio) {
        return gameRepository.findByDeveloperStudio(studio);
    }

    public List<Game> getAllGamesByPlatform (Platform platform) {
        return gameRepository.findByPlatforms(platform);
    }
}
