package us.zachandes.project10.service;

import org.springframework.data.repository.CrudRepository;
import us.zachandes.project10.controllers.Movie;

public interface MovieRepository extends CrudRepository<Movie, String> {
}