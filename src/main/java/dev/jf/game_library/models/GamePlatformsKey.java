package dev.jf.game_library.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class GamePlatformsKey {

    @Column(name="platform_id")
    int platformId;

    @Column(name="game_id")
    int gameId;

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.platformId;
        hash = 29 * hash + this.gameId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GamePlatformsKey other = (GamePlatformsKey) obj;
        if (this.platformId != other.platformId) {
            return false;
        }
        return this.gameId == other.gameId;
    }
}
