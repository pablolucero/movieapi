package com.disney.globant.movie;

import java.time.LocalDate;
import java.util.UUID;

public class Movie {
    public String id;
    public String title;
    public String synopsis;
    public LocalDate releaseDate;

    public Movie() {}

    public Movie(String title, String synopsis, LocalDate releaseDate) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
    }
}
