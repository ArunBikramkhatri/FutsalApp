package com.nura.futsalapp.dto;

public class FixtureDTO {
    private String player_one;
    private String player_two;
    private String status;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FixtureDTO() {
    }

    public String getPlayer_one() {
        return player_one;
    }

    public void setPlayer_one(String player_one) {
        this.player_one = player_one;
    }

    public String getPlayer_two() {
        return player_two;
    }

    public void setPlayer_two(String player_two) {
        this.player_two = player_two;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FixtureDTO{" +
                "player_one='" + player_one + '\'' +
                ", player_two='" + player_two + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
