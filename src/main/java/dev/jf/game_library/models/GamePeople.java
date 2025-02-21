package dev.jf.game_library.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "game_people")
public class GamePeople {

    @EmbeddedId
    GamePeopleKey gamePeopleId;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name="game_id")
    @JsonBackReference
    Game game;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name="person_id")
    @JsonManagedReference
    Person person;

    @Column(name="job_role")
    String jobRole;

    public GamePeopleKey getGamePeopleId() {
        return gamePeopleId;
    }

    public void setGamePeopleId(GamePeopleKey gamePeopleId) {
        this.gamePeopleId = gamePeopleId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String role) {
        this.jobRole = role;
    }
}
