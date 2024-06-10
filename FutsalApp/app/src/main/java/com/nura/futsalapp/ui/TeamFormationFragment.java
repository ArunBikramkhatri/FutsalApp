package com.nura.futsalapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.databinding.FragmentTeamFormationBinding;
import com.nura.futsalapp.databinding.PlayerCardBinding;
import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.model.TeamFormation;
import com.nura.futsalapp.recyclerViewAdapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class TeamFormationFragment extends Fragment {

    private RecyclerViewAdapter teamOneAdapter, teamTwoAdapter;

    private RecyclerView teamOneRecycler, teamTwoRecycler;

    private TeamFormation teamFormation;
    ArrayList<Player> teamOnePlayers, teamTwoPlayers;

    private Button button;

    private FragmentTeamFormationBinding formationBinding;

    private PlayerCardBinding team_one_p1;
    private View team_one_p2;
    private View team_one_p3;
    private View team_one_p4 ;


    Activity activity;
    public TeamFormationFragment(Activity activity){
        this.activity =activity ;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        formationBinding = FragmentTeamFormationBinding.inflate(getLayoutInflater());
        View view = formationBinding.getRoot();
        initFields(formationBinding);
        setClicklistener();
        return view;
//        View view = inflater.inflate(R.layout.fragment_team_formation,container ,false);
//        initFields(view);
//        setClicklistener();
//        return  view;


//        View view = inflater.inflate(R.layout.team_formation , container, false);
//        initFields(view);
//        setClicklistener();
//        return view;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        initFields();
//        setClicklistener();
//    }
//

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

//        teamFormation.addListPlayer(defenders);
//        teamFormation.makeTeam();
//        teamFormation.addListPlayer(goalkeepers);
//        teamFormation.makeTeam();
    }


    private void initFields(FragmentTeamFormationBinding view) {
        team_one_p1 = view.teamOneP1;
//        team_one_p2 = view.findViewById(R.id.team_one_p2);
//        team_one_p3 = view.findViewById(R.id.team_one_p3);
//        team_one_p4 = view.findViewById(R.id.team_one_p4);

        button = view.makeTeam;
//        teamOneRecycler = view.findViewById(R.id.team_one);
//        teamTwoRecycler = view.findViewById(R.id.team_two);

       team_one_p1.playerCardName.setText("Player 1");}

    public void initTeamOne() {



        teamOneAdapter = new RecyclerViewAdapter(teamFormation.getTeamOne());
        teamOneRecycler.setAdapter(teamOneAdapter);
        teamOneRecycler.setLayoutManager(new GridLayoutManager(activity ,2));

    }

    public void initTeamTwo() {
        teamTwoAdapter = new RecyclerViewAdapter(teamFormation.getTeamTwo());
        teamTwoRecycler.setAdapter(teamTwoAdapter);
        teamTwoRecycler.setLayoutManager(new GridLayoutManager(activity ,3));
    }


    private void setClicklistener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTeamFormation();
//                initTeamOne();
//                initTeamTwo();
            }
        });
    }

}