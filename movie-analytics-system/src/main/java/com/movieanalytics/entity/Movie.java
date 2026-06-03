package com.movieanalytics.entity;

//movies(movie_id, title, genre_id, release_year)
public class Movie {
    private int movieId;
    private String title;
    private int genreId;
    private int releaseYear;

    public Movie(int movieId, String title, int genreId, int releaseYear) {
        this.movieId = movieId;
        this.title = title;
        this.genreId = genreId;
        this.releaseYear = releaseYear;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getGenreId() {
        return genreId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}