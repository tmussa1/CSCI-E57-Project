package edu.harvard.e57.repository;

import edu.harvard.e57.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public List<Movie> findAllByViewer(String viewer);
}
