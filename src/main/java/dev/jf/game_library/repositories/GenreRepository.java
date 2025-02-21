package dev.jf.game_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jf.game_library.models.Genre;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

    
}
