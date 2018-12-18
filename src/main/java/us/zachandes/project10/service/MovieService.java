package us.zachandes.project10.service;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.zachandes.project10.controllers.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private static Log log = LogFactory.getLog(MovieService.class);

    private List<Movie> movies = new ArrayList<>(
            Arrays.asList(
                    new Movie("3 - Enjoy", "Action"),
                    new Movie("2 - Ambivalent", "Horror"),
                    new Movie("3 - Enjoy", "Comedy"),
                    new Movie("1 - Dislike", "Romance"),
                    new Movie("4 - Love", "Science Fiction")
            ));

    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        if(movies.size() == 0){
            movieRepository.save(new Movie("3 - Enjoy", "Action"));
            movieRepository.save(new Movie("2 - Ambivalent", "Horror"));
            movieRepository.save(new Movie("3 - Enjoy", "Comedy"));
            movieRepository.save(new Movie("1 - Dislike", "Romance"));
            movieRepository.save(new Movie("4 - Love", "Science Fiction"));
        }
        return movies;
    }

    public Movie getMovie(String id){
        return (Movie) movieRepository.findById(id).orElse(new Movie("NA", "Missing Genre"));
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
        log.info("Added Genre " + movie.getGenre() + " with Rating " + movie.getRating());
    }

    public void updateMovie(Movie movie, String id){
        for(int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            if (m.getGenre().equals(id)) {
                movieRepository.save(movie);
                log.info("Updated Genre " + movie.getGenre() + " with Rating " + movie.getRating());
                return;
            }
        }
    }

    public void deleteMovie(String id){
        log.info("Deleted Genre " + id);
        movieRepository.delete(getMovie(id));
    }
}
