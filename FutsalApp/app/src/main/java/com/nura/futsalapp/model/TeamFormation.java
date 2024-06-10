package com.nura.futsalapp.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TeamFormation {

    private String teamDetails;
    private JSONObject teams;

    private ArrayList<Player> playerArrayList;

    private ArrayList<Player> teamOne, teamTwo;


    public TeamFormation(ArrayList<Player> players) {
        this.playerArrayList = players;
        teamOne = new ArrayList<>();
        teamTwo = new ArrayList<>();
    }

    public ArrayList<Player> getTeamOne() {
        return teamOne;
    }

    public ArrayList<Player> getTeamTwo() {
        return teamTwo;
    }


    public void makeTeam(int range) {
//        int totalWeight = 0;
//        for (Player p : players){
//            totalWeight += Integer.valueOf(p.getRating());
//        }
//
//        System.out.println("total weight " + totalWeight);
        Random random = new Random();

        float toss = random.nextFloat();
        boolean teamOneChoose = false;
        if (toss > 0.5) {
            teamOneChoose = true;
        }
        if (playerArrayList.size()== 1){
            if (teamOneChoose){
                teamOne.add(playerArrayList.get(0));
                System.out.println(" last player Team One : " + playerArrayList.get(0).getName());

            }else {
                teamTwo.add(playerArrayList.get(0));
                System.out.println("last player Team two : " + playerArrayList.get(0).getName());
            }
            return;
        }
        for (int i = 0; i < range; i++) {
//            System.out.println("team one : " +teamOneChoose );
//            System.out.println("team Two : " +teamTwoChoose );
//            if(teamOneChoose) {

            int x = 0, y = 0;

            if (range == 2) {
                x = random.nextInt(4);
            } else {
                x = random.nextInt(playerArrayList.size());
            }
            System.out.println("Team One :" + playerArrayList.get(x).getName());

            teamOne.add(playerArrayList.get(x));
            playerArrayList.remove(x);
//                int y = random.nextInt(players.size());
//                teamTwo.add(players.get(y));
//                players.remove(y);
//                teamOneChoose = false ;
//                teamTwoChoose = true ;
//            }

//            if (teamTwoChoose){
            if (range == 2) {
                y = random.nextInt(4);
            } else {
                y = random.nextInt(playerArrayList.size());
            }
            System.out.println("Team two : " + playerArrayList.get(y).getName());
            teamTwo.add(playerArrayList.get(y));
            playerArrayList.remove(y);
//                int x = random.nextInt(players.size());
//                teamOne.add(players.get(x));
//                players.remove(x);
//                teamTwoChoose = false;
//                teamOneChoose = true;
//            }
        }
    }

    public void createTeam() {
        while (playerArrayList.size() != 0) {
            if (playerArrayList.size() >= 4) {
                makeTeam(2);
            } else {
                if (playerArrayList.size() % 2 == 0 && playerArrayList.size() > 0) {
                    makeTeam(1);
                } else if (playerArrayList.size() > 1) {
                    makeTeam(1);
                } else {
                    makeTeam(1);
                    break;
                }
            }
        }
    }


}
