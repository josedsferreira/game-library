package dev.jf.game_library.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class GamePeopleKey implements Serializable{

    @Column(name = "game_id")
    int  gameId;

    @Column(name = "person_id")
    int personId;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.gameId;
        hash = 37 * hash + this.personId;
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
        final GamePeopleKey other = (GamePeopleKey) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        return this.personId == other.personId;
    }
}
