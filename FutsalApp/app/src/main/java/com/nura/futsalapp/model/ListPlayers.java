package com.nura.futsalapp.model;

import java.util.ArrayList;

public class ListPlayers {

    private ArrayList<Player> players ;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ListPlayers() {
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "ListPlayers{" +
                "players=" + players +
                '}';
    }
}
