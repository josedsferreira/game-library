package dev.jf.game_library.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jf.game_library.models.Company;
import dev.jf.game_library.models.Game;
import dev.jf.game_library.models.GamePlatforms;
import dev.jf.game_library.models.Platform;


@Repository
public interface PlatformRepository extends JpaRepository<Platform, Integer>{

    List<Platform> findByGames(Set<GamePlatforms> games);
    List<Platform> findByGames(Game game);
    List<Platform> findByGeneration(Integer generation);
    List<Platform> findByManufacturer(Company manufacturer);
    List<Platform> findByProductFamily(String productFamily);

}
