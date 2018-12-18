package us.zachandes.project10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.zachandes.project10.service.MovieService;

import java.util.List;

@RestController
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/movies")
    public List<Movie> getMovies(){
        return movieService.getAllMovies();
    }

    @RequestMapping("/movie/{id}")
    public Movie getMovie(@PathVariable String id){
        return movieService.getMovie(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/movies")
    public void addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
    }

    @RequestMapping(method = RequestMethod.PUT, value=("/movies/{id}"))
    public void updateMovie(@RequestBody Movie movie, @PathVariable String id){
        movieService.updateMovie(movie,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/movies/{id}")
    public void deleteMovie(@PathVariable String id){
        movieService.deleteMovie(id);
    }

}
