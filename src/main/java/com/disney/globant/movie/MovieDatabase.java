package com.disney.globant.movie;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A simple database of movies
 */
@Component
public class MovieDatabase {

    private List<Movie> movies;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
        movies.add(new Movie("Zootopia",
                "In a city of anthropomorphic animals, a rookie bunny cop and a cynical con artist fox must work together to uncover a conspiracy.",
                LocalDate.of(2016, 3, 4)));
        movies.add(new Movie("The Jungle Book",
                "After a threat from the tiger Shere Khan forces him to flee the jungle, a man-cub named Mowgli embarks on a journey of self discovery with the help of panther, Bagheera, and free spirited bear, Baloo.",
                LocalDate.of(2016, 4, 15)));
        movies.add(new Movie("Doctor Strange",
                "A former neurosurgeon embarks on a journey of healing only to be drawn into the world of the mystic arts.",
                LocalDate.of(2016, 11, 4)));
        movies.add(new Movie("Beauty and the Beast",
                "An adaptation of the Disney fairy tale about a monstrous-looking prince and a young woman who fall in love.",
                LocalDate.of(2017, 3, 17)));
        movies.add(new Movie("Guardians of the Galazy Vol. 2",
                "Set to the backdrop of Awesome Mixtape #2, 'Guardians of the Galaxy Vol. 2' continues the team's adventures as they unravel the mystery of Peter Quill's true parentage. ",
                LocalDate.of(2017, 5, 5)));
        movies.add(new Movie("Born in China",
                "A wildlife drama that follows the families of endangered animals in China. ",
                LocalDate.of(2017, 4, 21)));
    }

    public List<Movie> findAllMovies() {
        return movies;
    }

    public Movie findMovieById(String id) {
        return movies.stream().filter(movie -> movie.id.equals(id)).findFirst().orElseGet(() -> null);
    }

    public List<Movie> findByReleaseDate(Integer year) {
        return (List<Movie>) movies.stream()
                .filter(movie -> (movie.releaseDate.getYear() == year))
                .collect(Collectors.toList());
    }


}
