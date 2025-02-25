package dev.jf.game_library.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.jf.game_library.models.Company;
import dev.jf.game_library.models.Game;
import dev.jf.game_library.models.Genre;
import dev.jf.game_library.models.Person;
import dev.jf.game_library.models.Platform;
import dev.jf.game_library.services.GameService;

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins = "${frontend.url}")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public List<Game> getAllGames() {
        return service.getAllGames();
    }

    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        // create some filtering for the status
        Game savedGame = service.saveGame(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }

    // FIND BY ID
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable int id) {
        Optional<Game> game = service.getGameById(id);
        if (game.isEmpty()) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Game not found with ID " + id
            );
        }
        else return game.get();
    }

    // FIND BY DIRECTOR
    @GetMapping("/director")
    public List<Game> getGamesByDirector(@RequestBody Person director) {
        List<Game> games = service.getAllGamesByDirector(director);
        if (games.isEmpty()) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Games not found with director " + director
            );
        }
        else return games;
    }

    // FIND BY Genre
    @GetMapping("/genre")
    public List<Game> getGamesByGenre(@RequestBody Genre genre) {
        List<Game> games = service.getAllGamesInGenre(genre);
        if (games.isEmpty()) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Games not found in genre " + genre
            );
        }
        else return games;
    }

    // FIND BY Genre
    /* @GetMapping("/genre")
    public List<Game> getGamesByGenre(@RequestBody Set<Genre> genres) {
        List<Game> games = service.getAllGamesInGenre(genres);
        if (games.isEmpty()) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Games not found in genres " + genres
            );
        }
        else return games;
    } */

    // FIND BY COMPANY
    @GetMapping("/company")
    public List<Game> getGamesByCompany(@RequestBody Company company) {
        List<Game> games = service.getAllGamesByCompany(company);
        if (games.isEmpty()) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Games not found with company " + company
            );
        }
        else return games;
    }

    // FIND BY PLATFORM
    @GetMapping("/platform")
    public List<Game> getGamesByPlatform(@RequestBody Platform platform) {
        List<Game> games = service.getAllGamesByPlatform(platform);
        if (games.isEmpty()) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Games not found with platform " + platform
            );
        }
        else return games;
    }

}
