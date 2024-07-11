package com.nura.futsalapp.model;

public class Fixture {
    private Player playerOne ;
    private Player playerTwo ;

    private String score ;
    private String date ;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Fixture() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Fixture(Player playerOne, Player playerTwo, String score, String date) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.score = score;
        this.date = date;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    @Override
    public String toString() {
        return "Fixture{" +
                "playerOne=" + playerOne +
                ", playerTwo=" + playerTwo +
                ", score='" + score + '\'' +
                '}';
    }
}
