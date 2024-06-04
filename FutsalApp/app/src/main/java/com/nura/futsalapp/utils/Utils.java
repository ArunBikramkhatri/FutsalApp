package com.nura.futsalapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nura.futsalapp.model.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {


    public static ArrayList<Player> getListPlayer(String jsonPlayer){

        Player[]  players ;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            players = objectMapper.readValue(jsonPlayer, Player[].class);
            ArrayList<Player> playerArrayList = new ArrayList<Player>(Arrays.asList(players));
            return playerArrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
