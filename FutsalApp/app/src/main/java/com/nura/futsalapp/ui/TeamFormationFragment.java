package com.nura.futsalapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nura.futsalapp.MainActivity;
import com.nura.futsalapp.databinding.FragmentTeamFormationBinding;
import com.nura.futsalapp.databinding.PlayerCardBinding;
import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.model.PlayersList;
import com.nura.futsalapp.model.TeamFormation;
import com.nura.futsalapp.recyclerViewAdapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class TeamFormationFragment extends Fragment {

    private static final String TAG = "TeamFormationFragment";
    private RecyclerViewAdapter teamOneAdapter, teamTwoAdapter;

    private RecyclerView teamOneRecycler, teamTwoRecycler;

    private PlayersList players;
    private TeamFormation teamFormation;
    ArrayList<Player> teamOnePlayers, teamTwoPlayers;

    private Button button;

    private FragmentTeamFormationBinding formationBinding;

    private PlayerCardBinding team_one_p1,team_one_p2,team_one_p3,team_one_p4;
    private PlayerCardBinding team_two_p1,team_two_p2,team_two_p3,team_two_p4;


    Activity activity;

    public TeamFormationFragment(Activity activity, PlayersList players) {
        this.activity = activity;
        players.sort();
        this.players = players;

    }

    private void createTeams() {
        teamFormation = new TeamFormation(new ArrayList<>(players.getPlayers()));
        Log.d(TAG, "createTeams: " + players.toString());
        if (players.getPlayers().size() >= 8) {
            teamFormation.createTeam();
        }else {
            Log.d(TAG, "createTeams: players numbers is less than 8" );
        }
        teamOnePlayers = teamFormation.getTeamOne();
        teamTwoPlayers = teamFormation.getTeamTwo();

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
        setClicklistener(view);
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
        team_one_p2 = view.teamOneP2;
        team_one_p3 = view.teamOneP3;
        team_one_p4 = view.teamOneP4;

        team_two_p1 = view.teamTwoP1;
        team_two_p2 = view.teamTwoP2;
        team_two_p3 = view.teamTwoP3;
        team_two_p4 = view.teamTwoP4;
//        team_one_p2 = view.findViewById(R.id.team_one_p2);
//        team_one_p3 = view.findViewById(R.id.team_one_p3);
//        team_one_p4 = view.findViewById(R.id.team_one_p4);

        button = view.makeTeam;
//        teamOneRecycler = view.findViewById(R.id.team_one);
//        teamTwoRecycler = view.findViewById(R.id.team_two);
    }

    public void initTeamOne() {


        teamOneAdapter = new RecyclerViewAdapter(teamFormation.getTeamOne());
        teamOneRecycler.setAdapter(teamOneAdapter);
        teamOneRecycler.setLayoutManager(new GridLayoutManager(activity, 2));

    }

    public void initTeamTwo() {
        teamTwoAdapter = new RecyclerViewAdapter(teamFormation.getTeamTwo());
        teamTwoRecycler.setAdapter(teamTwoAdapter);
        teamTwoRecycler.setLayoutManager(new GridLayoutManager(activity, 3));
    }


    private void setClicklistener(View view) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTeams();
                setField();
//                initTeamFormation();
//                initTeamOne();
//                initTeamTwo();
            }
        });
    }

    private void setField(){
        team_one_p1.playerCardName.setText(teamOnePlayers.get(0).getNickName());
        team_one_p1.playerImg.setImageResource(teamOnePlayers.get(0).getImageResId());

        team_one_p2.playerCardName.setText(teamOnePlayers.get(1).getNickName());
        team_one_p2.playerImg.setImageResource(teamOnePlayers.get(1).getImageResId());

        team_one_p3.playerCardName.setText(teamOnePlayers.get(2).getNickName());
        team_one_p3.playerImg.setImageResource(teamOnePlayers.get(2).getImageResId());

        team_one_p4.playerCardName.setText(teamOnePlayers.get(3).getNickName());
        team_one_p4.playerImg.setImageResource(teamOnePlayers.get(3).getImageResId());

        team_two_p1.playerCardName.setText(teamTwoPlayers.get(0).getNickName());
        team_two_p1.playerImg.setImageResource(teamTwoPlayers.get(0).getImageResId());

        team_two_p2.playerCardName.setText(teamTwoPlayers.get(1).getNickName());
        team_two_p2.playerImg.setImageResource(teamTwoPlayers.get(1).getImageResId());

        team_two_p3.playerCardName.setText(teamTwoPlayers.get(2).getNickName());
        team_two_p3.playerImg.setImageResource(teamTwoPlayers.get(2).getImageResId());

        team_two_p4.playerCardName.setText(teamTwoPlayers.get(3).getNickName());
        team_two_p4.playerImg.setImageResource(teamTwoPlayers.get(3).getImageResId());
    }

}