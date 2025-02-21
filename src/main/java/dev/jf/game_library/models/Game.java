package dev.jf.game_library.models;

import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    // Foreign key to the company (developer studio)
    @ManyToOne
    @JoinColumn(name = "developer_studio", referencedColumnName = "company_id", nullable = true)
    @OnDelete(action=OnDeleteAction.SET_NULL)
    private Company developerStudio;

    // Foreign key to the company (publisher)
    @ManyToOne
    @JoinColumn(name = "publisher", referencedColumnName = "company_id", nullable = true)
    @OnDelete(action=OnDeleteAction.SET_NULL)
    private Company publisher;

    // Foreign key to the person (director)
    @ManyToOne
    @JoinColumn(name = "director", referencedColumnName = "person_id", nullable = true)
    @OnDelete(action=OnDeleteAction.SET_NULL)
    private Person director;

    // Foreign key to the series
    @ManyToOne
    @JoinColumn(name = "game_series", referencedColumnName = "series_id", nullable = true)
    @OnDelete(action=OnDeleteAction.SET_NULL)
    private Series gameSeries;

    // Many to Many relations that have extra atributes
    @OneToMany(mappedBy="game")
    Set<GamePeople> developers;

    @OneToMany(mappedBy="game")
    Set<GamePlatforms> platforms;

    // Simple many to many relations
    @ManyToMany
    @JoinTable(
        name = "game_genres", 
        joinColumns = @JoinColumn(name = "game_id"), 
        inverseJoinColumns = @JoinColumn(name = "genre_id"))
    Set<Genre> genres;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company getDeveloperStudio() {
        return developerStudio;
    }

    public void setDeveloperStudio(Company developerStudio) {
        this.developerStudio = developerStudio;
    }

    public Company getPublisher() {
        return publisher;
    }

    public void setPublisher(Company publisher) {
        this.publisher = publisher;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public Series getGameSeries() {
        return gameSeries;
    }

    public void setGameSeries(Series gameSeries) {
        this.gameSeries = gameSeries;
    }

    public Set<GamePeople> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<GamePeople> developers) {
        this.developers = developers;
    }

    public Set<GamePlatforms> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<GamePlatforms> platforms) {
        this.platforms = platforms;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }


}
