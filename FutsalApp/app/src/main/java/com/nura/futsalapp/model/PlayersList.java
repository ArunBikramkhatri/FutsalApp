package com.nura.futsalapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class PlayersList {
    @JsonProperty("players")
    private ArrayList<Player> players;

    private static PlayersList playersList;
    public static PlayersList getInstance(){
        if (playersList == null){
            playersList = new PlayersList();
        }
        return playersList;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void sort(){
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Integer.compare(p2.getRating() , p1.getRating());
            }
        });
    }
}
