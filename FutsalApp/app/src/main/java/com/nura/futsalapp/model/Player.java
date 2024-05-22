package com.nura.futsalapp.model;

public class Player {

    private String name ;
    private String rating;
    private String position ;

    public Player() {
    }

    public Player(String name, String rating, String position) {
        this.name = name;
        this.rating = rating;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
