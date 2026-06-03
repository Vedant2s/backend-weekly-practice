package com.movieanalytics.entity;

//ratings(rating_id, user_id, movie_id, rating, rating_date)
import java.util.Date;

public class Rating {
    private int ratingId;
    private int userId;
    private int movieId;
    private double rating;
    private Date ratingDate;

    public Rating(int ratingId, int userId, int movieId, double rating, Date ratingDate) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.ratingDate = ratingDate;
    }

    public int getRatingId() {
        return ratingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public double getRating() {
        return rating;
    }

    public Date getRatingDate() {
        return ratingDate;
    }
}