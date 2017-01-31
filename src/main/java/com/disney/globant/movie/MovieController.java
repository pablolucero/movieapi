package com.disney.globant.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class MovieController {

    @Autowired
    private MovieDatabase movieDatabase;

    @RequestMapping(value = "/movies", method = GET)
    public List<Movie> movies() {
        return movieDatabase.findAllMovies();
    }

    @RequestMapping(value = "/movie", method = GET, params="id")
    public Movie movie(@RequestParam(value="id") String id) {
        return movieDatabase.findMovieById(id);
    }

    @RequestMapping(value = "/movie", method = GET, params="year")
    public List<Movie> movie(@RequestParam(value="year") Integer year) {
        return movieDatabase.findByReleaseDate(year);
    }

}
