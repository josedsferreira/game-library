package dev.jf.game_library.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.jf.game_library.models.Game;
import dev.jf.game_library.models.GamePlatforms;
import dev.jf.game_library.models.Platform;
import dev.jf.game_library.repositories.GamePlatformsRepository;

@Service
public class GamePlatformsService {

    private final GamePlatformsRepository repository;

    public GamePlatformsService(GamePlatformsRepository repository){
        this.repository = repository;
    }

    public List<GamePlatforms> getAllGamePlatforms() {
        return repository.findAll();
    }

    public GamePlatforms saveGamePlatforms(GamePlatforms gamePlatforms) {
        return repository.save(gamePlatforms);
    }

    public List<GamePlatforms> getAlGamePlatformsByGame(Game game) {
        return repository.findByGame(game);
    }

    public List<GamePlatforms> getAlGamePlatformsByPlatform(Platform platform) {
        return repository.findByPlatform(platform);
    }
}
