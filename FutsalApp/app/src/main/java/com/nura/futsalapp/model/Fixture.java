package com.nura.futsalapp.model;

public class Fixture {
    private Player playerOne ;
    private Player playerTwo ;

    private String score ;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Fixture() {
    }

    public Fixture(Player playerOne, Player playerTwo, String score) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerOne.setCaptain(true);
        this.playerTwo.setCaptain(true);
        this.score = score;
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
