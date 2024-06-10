package com.nura.futsalapp.model;

public class CaptainDetails {
    public String logo;
    public String name;
    public int matches_played;
    public int win;
    public int draw;
    public int loss;
    public int goal_forward;
    public int goal_against;
    public int goal_difference;
    public int points;

    public CaptainDetails() {
    }

    public CaptainDetails(String logo, String name, int matches_played, int win, int draw, int loss, int goal_forward, int goal_against, int goal_difference, int points) {
        this.logo = logo;
        this.name = name;
        this.matches_played = matches_played;
        this.win = win;
        this.draw = draw;
        this.loss = loss;
        this.goal_forward = goal_forward;
        this.goal_against = goal_against;
        this.goal_difference = goal_difference;
        this.points = points;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatches_played() {
        return matches_played;
    }

    public void setMatches_played(int matches_played) {
        this.matches_played = matches_played;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getGoal_forward() {
        return goal_forward;
    }

    public void setGoal_forward(int goal_forward) {
        this.goal_forward = goal_forward;
    }

    public int getGoal_against() {
        return goal_against;
    }

    public void setGoal_against(int goal_against) {
        this.goal_against = goal_against;
    }

    public int getGoal_difference() {
        return goal_difference;
    }

    public void setGoal_difference(int goal_difference) {
        this.goal_difference = goal_difference;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
