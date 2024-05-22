package com.nura.futsalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.model.TeamFormation;
import com.nura.futsalapp.recyclerViewAdapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter teamOneAdapter, teamTwoAdapter;

    private RecyclerView teamOneRecycler, teamTwoRecycler;

    private TeamFormation teamFormation;
    ArrayList<Player> teamOnePlayers, teamTwoPlayers;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFields();
        setClicklistener();
    }


    private void initTeamFormation() {

        String forwards = "[\n" +
                "    {\"name\": \"Lionel Messi\", \"rating\": 8, \"position\": \"ST\"},\n" +
                "    {\"name\": \"Cristiano Ronaldo\", \"rating\": 8, \"position\": \"ST\"},\n" +
                "    {\"name\": \"Neymar Jr\", \"rating\": 8, \"position\": \"ST\"},\n" +
                "    {\"name\": \"Kylian Mbappe\", \"rating\": 7, \"position\": \"ST\"}\n" +
                "]\n";

        String midfields = "[\n" +
                "    {\"name\": \"Kevin De Bruyne\", \"rating\": 8, \"position\": \"CMF\"},\n" +
                "    {\"name\": \"Luka Modric\", \"rating\": 8, \"position\": \"CMF\"},\n" +
                "    {\"name\": \"Paul Pogba\", \"rating\": 8, \"position\": \"CMF\"},\n" +
                "    {\"name\": \"Toni Kroos\", \"rating\": 7, \"position\": \"CMF\"}\n" +
                "]\n";

        String defenders = "[\n" +
                "    {\"name\": \"Virgil van Dijk\", \"rating\": 8, \"position\": \"CB\"},\n" +
                "    {\"name\": \"Sergio Ramos\", \"rating\": 8, \"position\": \"CB\"},\n" +
                "    {\"name\": \"Giorgio Chiellini\", \"rating\": 8, \"position\": \"CB\"},\n" +
                "    {\"name\": \"Thiago Silva\", \"rating\": 7, \"position\": \"CB\"}\n" +
                "]\n";


        String goalkeepers = "[\n" +
                "    {\"name\": \"David De Gea\", \"rating\": 7, \"position\": \"GK\"},\n" +
                "    {\"name\": \"Manuel Neuer\", \"rating\": 7, \"position\": \"GK\"}\n" +
                "]\n";

        teamFormation = new TeamFormation();
        teamFormation.addListPlayer(forwards);
        teamFormation.makeTeam();
        teamFormation.addListPlayer(midfields);
        teamFormation.makeTeam();
        teamFormation.addListPlayer(defenders);
        teamFormation.makeTeam();
        teamFormation.addListPlayer(goalkeepers);
        teamFormation.makeTeam();
    }


    private void initFields() {
        button = findViewById(R.id.make_team);
        teamOneRecycler = findViewById(R.id.team_one);
        teamTwoRecycler = findViewById(R.id.team_two);
    }

    public void initTeamOne() {
        teamOneAdapter = new RecyclerViewAdapter(teamFormation.getTeamOne());
        teamOneRecycler.setAdapter(teamOneAdapter);
        teamOneRecycler.setLayoutManager(new LinearLayoutManager(this));

    }

    public void initTeamTwo() {

        teamTwoAdapter = new RecyclerViewAdapter(teamFormation.getTeamTwo());
        teamTwoRecycler.setAdapter(teamTwoAdapter);
        teamTwoRecycler.setLayoutManager(new LinearLayoutManager(this));
    }


    private void setClicklistener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTeamFormation();
                initTeamOne();
                initTeamTwo();
            }
        });
    }

}