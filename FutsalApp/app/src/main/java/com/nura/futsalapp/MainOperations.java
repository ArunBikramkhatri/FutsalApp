package com.nura.futsalapp;

import android.content.Context;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nura.futsalapp.data.FixtureData;
import com.nura.futsalapp.data.PlayerData;
import com.nura.futsalapp.dto.FixtureDTO;
import com.nura.futsalapp.dto.FixtureListDTO;
import com.nura.futsalapp.model.Fixture;
import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.model.PlayersList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainOperations {

    private static final String TAG = "MainOperations";

    public static PlayersList initPlayerData(Context context ,String data) {
        PlayersList players = null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            players = objectMapper.readValue(data, PlayersList.class);

            for (Player player : players.getPlayers()) {
//                Log.i(TAG, "initPlayerData: " + player.toString());
                player.resolveImageResId(context);
            }
//            players.sort();

        } catch (Exception e) {
            Log.e(TAG, "initPlayerData: " + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return players;
    }


    public static FixtureListDTO initFixtureData() {
        ObjectMapper objectMapper = new ObjectMapper();
        FixtureListDTO fixtures = null;
        String fixtureJson = FixtureData.getFixtureData();
        try {
            fixtures = objectMapper.readValue(fixtureJson, FixtureListDTO.class);

            for (FixtureDTO fixtureDTO : fixtures.getFixtureDTOS()) {
                Log.i(TAG, "initPlayerData: " + fixtureDTO.toString());
            }
        } catch (Exception e) {
            Log.e(TAG, "initFixtureData: " + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return fixtures;
    }


    public static ArrayList<Fixture> initFixturesRecyclerData(PlayersList players) {
        FixtureListDTO fixtures = null;
        ArrayList<Fixture> fixtureArrayList = new ArrayList<>();
        try {
            fixtures = MainOperations.initFixtureData();
            for (FixtureDTO fixtureDTO : fixtures.getFixtureDTOS()) {
                Player p1 = null, p2 = null;

                for (Player player : players.getPlayers()) {
                    if (p1 != null && p2 != null) {
                        break;
                    }
                    if (fixtureDTO.getPlayer_one().equals(player.getName())) {
                        p1 = player;
                        continue;
                    }
                    if (fixtureDTO.getPlayer_two().equals(player.getName())) {
                        p2 = player;
                        continue;
                    }

                }
                fixtureArrayList.add(new Fixture(p1, p2, fixtureDTO.getStatus()));
                Log.d(TAG, "initFixturesRecyclerData: " + fixtureArrayList.toString());
            }

        } catch (Exception e) {
            Log.e(TAG, "initFixturesRecyclerData: " + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return fixtureArrayList;
    }


    public static PlayersList testPlayerData(String data) {
        PlayersList players = null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            players = objectMapper.readValue(data, PlayersList.class);
            players.sort();

        } catch (Exception e) {
            Log.e(TAG, "initPlayerData: " + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
        return players;
    }

}
