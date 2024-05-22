package com.nura.futsalapp.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TeamFormation {

    private String teamDetails;
    private JSONObject teams ;

    private ArrayList<Player>  playerArrayList ;

    private ArrayList<Player> teamOne , teamTwo ;



    public TeamFormation() {
        teamOne = new ArrayList<>();
        teamTwo = new ArrayList<>();
    }

    public ArrayList<Player> getTeamOne() {
        return teamOne;
    }

    public ArrayList<Player> getTeamTwo() {
        return teamTwo;
    }

    public void addListPlayer(String jsonPlayer){

        Player[]  players ;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            players = objectMapper.readValue(jsonPlayer, Player[].class);
            playerArrayList = new ArrayList<Player>(Arrays.asList(players));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void makeTeam(){
//        int totalWeight = 0;
//        for (Player p : players){
//            totalWeight += Integer.valueOf(p.getRating());
//        }
//
//        System.out.println("total weight " + totalWeight);
        Random random =  new Random();

        float toss = random.nextFloat();
        boolean teamOneChoose =false , teamTwoChoose =false;
        if (toss > 0.5){
            teamOneChoose = true;
        }
        else {
            teamTwoChoose = true ;
        }
        for (int i = 0; i < 2; i++) {
//            System.out.println("team one : " +teamOneChoose );
//            System.out.println("team Two : " +teamTwoChoose );
//            if(teamOneChoose) {

                int x = random.nextInt(playerArrayList.size());
                System.out.println("Team One :" + x);



                teamOne.add(playerArrayList.get(x));
                playerArrayList.remove(x);
//                int y = random.nextInt(players.size());
//                teamTwo.add(players.get(y));
//                players.remove(y);
//                teamOneChoose = false ;
//                teamTwoChoose = true ;
//            }

//            if (teamTwoChoose){
                int y = random.nextInt(playerArrayList.size());
                System.out.println("Team two : " + y);
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


}
