package us.zachandes.project10.controllers;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private String genre;
    private String rating;

    public Movie(String rating, String genre){
        this.rating = rating;
        this.genre = genre;
    }

    public Movie(){

    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}