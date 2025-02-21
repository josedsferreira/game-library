package dev.jf.game_library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jf.game_library.models.Game;
import dev.jf.game_library.models.GamePlatforms;
import dev.jf.game_library.models.GamePlatformsKey;
import dev.jf.game_library.models.Platform;

@Repository
public interface GamePlatformsRepository extends JpaRepository<GamePlatforms, GamePlatformsKey>{

    List<GamePlatforms> findByGame(Game game);
    List<GamePlatforms> findByPlatform(Platform platform);
}
