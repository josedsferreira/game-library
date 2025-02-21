package dev.jf.game_library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.jf.game_library.models.Series;
import dev.jf.game_library.repositories.SeriesRepository;

@Service
public class SeriesService {

    private final SeriesRepository repository;

    public SeriesService(SeriesRepository repository) {
        this.repository = repository;
    }

    public Optional<Series> getSeriesById(Integer id) {
        return repository.findById(id);
    }

    public List<Series> getAllSeries() {
        return repository.findAll();
    }

    public Series saveSeries(Series series) {
        return repository.save(series);
    }

    
}
