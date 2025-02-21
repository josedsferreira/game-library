package dev.jf.game_library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.jf.game_library.models.Genre;
import dev.jf.game_library.repositories.GenreRepository;

@Service
public class GenreService {

    private final GenreRepository repository;

    public GenreService(GenreRepository repository) {
        this.repository = repository;
    }

    public Optional<Genre> getGenreById(Integer id) {
        return repository.findById(id);
    }

    public List<Genre> getAllGenres() {
        return repository.findAll();
    }

    public Genre saveGenre(Genre genre) {
        return repository.save(genre);
    }

    
}
