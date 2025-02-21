package dev.jf.game_library.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dev.jf.game_library.models.Company;
import dev.jf.game_library.models.Game;
import dev.jf.game_library.models.GamePlatforms;
import dev.jf.game_library.models.Platform;
import dev.jf.game_library.repositories.PlatformRepository;

@Service
public class PlatformService {

    private final PlatformRepository repository;

    public PlatformService(PlatformRepository repository) {
        this.repository = repository;
    }

    public Optional<Platform> getPlatformById(Integer id) {
        return repository.findById(id);
    }

    public List<Platform> getAllPlatforms() {
        return repository.findAll();
    }

    public Platform savePlatform(Platform platform) {
        return repository.save(platform);
    }

    public List<Platform> getAllPlatformsByGames(Set<GamePlatforms> games) {
        return repository.findByGames(games);
    }

    public List<Platform> getAllPlatformsByGames(Game game) {
        return repository.findByGames(game);
    }

    public List<Platform> getAllPlatformsByGeneration(Integer generation) {
        return repository.findByGeneration(generation);
    }

    public List<Platform> getAllPlatformsByManufacturer(Company manufacturer) {
        return repository.findByManufacturer(manufacturer);
    }

    public List<Platform> getAllPlatformsByFamily(String family) {
        return repository.findByProductFamily(family);
    }
}
