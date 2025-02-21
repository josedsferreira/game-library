package dev.jf.game_library.models;

import java.time.LocalDate;

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
@Table(name="game_platforms")
public class GamePlatforms {

    @EmbeddedId
    GamePlatformsKey gamePlatformsKey;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name="game_id")
    @JsonBackReference
    Game game;

    @ManyToOne
    @MapsId("platformId")
    @JoinColumn(name="platform_id")
    @JsonManagedReference
    Platform platform;

    @Column(name="release_date_NA")
    private LocalDate ReleaseDateNA;

    @Column(name="release_date_JP")
    private LocalDate ReleaseDateJP;

    @Column(name="release_date_EU")
    private LocalDate ReleaseDateEu;

    public GamePlatformsKey getGamePlatformsKey() {
        return gamePlatformsKey;
    }

    public void setGamePlatformsKey(GamePlatformsKey gamePlatformsKey) {
        this.gamePlatformsKey = gamePlatformsKey;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public LocalDate getReleaseDateNA() {
        return ReleaseDateNA;
    }

    public void setReleaseDateNA(LocalDate ReleaseDateNA) {
        this.ReleaseDateNA = ReleaseDateNA;
    }

    public LocalDate getReleaseDateJP() {
        return ReleaseDateJP;
    }

    public void setReleaseDateJP(LocalDate ReleaseDateJP) {
        this.ReleaseDateJP = ReleaseDateJP;
    }

    public LocalDate getReleaseDateEu() {
        return ReleaseDateEu;
    }

    public void setReleaseDateEu(LocalDate ReleaseDateEu) {
        this.ReleaseDateEu = ReleaseDateEu;
    }
}
