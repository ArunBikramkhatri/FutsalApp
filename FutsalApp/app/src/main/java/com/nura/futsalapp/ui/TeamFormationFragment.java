package com.nura.futsalapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nura.futsalapp.R;
import com.nura.futsalapp.databinding.FragmentTeamFormationBinding;
import com.nura.futsalapp.databinding.PlayerCardBinding;
import com.nura.futsalapp.databinding.PlayerStatPopUpBinding;
import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.model.PlayersList;
import com.nura.futsalapp.model.TeamFormation;
import com.nura.futsalapp.recyclerViewAdapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class TeamFormationFragment extends Fragment {

    private static final String TAG = "TeamFormationFragment";
    private RecyclerViewAdapter teamOneAdapter, teamTwoAdapter;

    private RecyclerView teamOneRecycler, teamTwoRecycler;

    private PlayersList players;
    private TeamFormation teamFormation;
    ArrayList<Player> teamOnePlayers, teamTwoPlayers;
    ArrayList<Player> keepers;

    private FloatingActionButton makeTeam;

    private FragmentTeamFormationBinding formationBinding;

    private PlayerCardBinding team_one_p1, team_one_p2, team_one_p3, team_one_p4 ,team_one_keeper;
    private PlayerCardBinding team_two_p1, team_two_p2, team_two_p3, team_two_p4 , team_two_keeper;

    private ArrayList<PlayerCardBinding> teamOnePlayerCardBindings, teamTwoPlayerCardBindings;


    PlayerStatPopUpBinding playerStatPopUpBinding;
    private Dialog playerPopUp;

    Activity activity;

    public TeamFormationFragment(Activity activity, PlayersList players) {
        this.activity = activity;
        players.sort();
        this.players = players;

        initPlayerPopUp();
    }

    private void initPlayerPopUp(){
        playerPopUp = new Dialog(activity);
//        playerPopUp.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        playerPopUp.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//
//
//        // Hide system bars in the dialog
//        WindowInsetsControllerCompat windowInsetsControllerCompat = WindowCompat.getInsetsController(playerPopUp.getWindow(), playerPopUp.getWindow().getDecorView());
//        if (windowInsetsControllerCompat != null) {
//            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
//            windowInsetsControllerCompat.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
//        }
    }
    private void initPlayerCardBinding() {
        teamOnePlayerCardBindings = new ArrayList<>();
        teamOnePlayerCardBindings.add(team_one_p1);
        teamOnePlayerCardBindings.add(team_one_p2);
        teamOnePlayerCardBindings.add(team_one_p3);
        teamOnePlayerCardBindings.add(team_one_p4);


        teamTwoPlayerCardBindings = new ArrayList<>();
        teamTwoPlayerCardBindings.add(team_two_p1);
        teamTwoPlayerCardBindings.add(team_two_p2);
        teamTwoPlayerCardBindings.add(team_two_p3);
        teamTwoPlayerCardBindings.add(team_two_p4);

        setPlayerOnClickListener();

    }

    private void createTeams() {
        keepers = new ArrayList<>();
        teamFormation = new TeamFormation(new ArrayList<>(players.getPlayers()));
        Log.d(TAG, "createTeams: " + players.toString());
        if (players.getPlayers().size() >= 8) {
            teamFormation.createTeam();
        } else {
            Log.d(TAG, "createTeams: players numbers is less than 8");
        }
        teamOnePlayers = teamFormation.getTeamOne();
        teamTwoPlayers = teamFormation.getTeamTwo();

        keepers.add(teamOnePlayers.get(teamOnePlayers.size() -1));
        keepers.add(teamTwoPlayers.get(teamTwoPlayers.size() -1));

        teamOnePlayers.remove(teamOnePlayers.get(teamOnePlayers.size() -1));
        teamTwoPlayers.remove(teamTwoPlayers.get(teamOnePlayers.size() -1));

        Collections.shuffle(teamOnePlayers);
        Collections.shuffle(teamTwoPlayers);

//        Collections.shuffle(keepers);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        playerStatPopUpBinding = PlayerStatPopUpBinding.inflate(getLayoutInflater());
        formationBinding = FragmentTeamFormationBinding.inflate(getLayoutInflater());
        View view = formationBinding.getRoot();
        initFields(formationBinding);
        setClicklistener(view);
        return view;

    }


    private void initFields(FragmentTeamFormationBinding view) {
        team_one_p1 = view.teamOneP1;
        team_one_p2 = view.teamOneP2;
        team_one_p3 = view.teamOneP3;
        team_one_p4 = view.teamOneP4;
        team_one_keeper = view.keeperOne;

        team_two_p1 = view.teamTwoP1;
        team_two_p2 = view.teamTwoP2;
        team_two_p3 = view.teamTwoP3;
        team_two_p4 = view.teamTwoP4;
        team_two_keeper = view.keeperTwo;

        makeTeam = view.makeTeam;

        initPlayerCardBinding();

    }


    private void setClicklistener(View view) {
        makeTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAnimation();

                createTeams();
                setField();
            }
        });
    }

    private void playAnimation() {
        Animation animation
                = AnimationUtils
                .loadAnimation(
                        getContext(),
                        R.anim.blink);
        // call the startAnimation method

        for (PlayerCardBinding p : teamOnePlayerCardBindings) {
            p.playerCardName.setAnimation(animation);
            p.playerImg.setAnimation(animation);
        }
        team_one_keeper.playerCardName.setAnimation(animation);
        team_one_keeper.playerImg.setAnimation(animation);

        for (PlayerCardBinding p : teamTwoPlayerCardBindings) {
            p.playerCardName.setAnimation(animation);
            p.playerImg.setAnimation(animation);
        }
        team_two_keeper.playerCardName.setAnimation(animation);
        team_two_keeper.playerImg.setAnimation(animation);
    }

    private void setField() {
        for (int i = 0; i < teamOnePlayerCardBindings.size(); i++) {
            teamOnePlayerCardBindings.get(i).playerCardName.setText(teamOnePlayers.get(i).getNickName());
            teamOnePlayerCardBindings.get(i).playerImg.setImageResource(teamOnePlayers.get(i).getImageResId());
        }
        team_one_keeper.playerImg.setImageResource(keepers.get(0).getImageResId());
        team_one_keeper.playerCardName.setText(keepers.get(0).getNickName());
        for (int i = 0; i < teamTwoPlayerCardBindings.size(); i++) {
            teamTwoPlayerCardBindings.get(i).playerCardName.setText(teamTwoPlayers.get(i).getNickName());
            teamTwoPlayerCardBindings.get(i).playerImg.setImageResource(teamTwoPlayers.get(i).getImageResId());
        }
        team_two_keeper.playerCardName.setText(keepers.get(1).getNickName());
        team_two_keeper.playerImg.setImageResource(keepers.get(1).getImageResId());
    }

    private void setPlayerOnClickListener(){
        for (PlayerCardBinding p : teamOnePlayerCardBindings) {
            p.playerCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerPopUp.setContentView(playerStatPopUpBinding.playerStatPopUp) ;
                    playerStatPopUpBinding.playerStatImg.setImageResource(Integer.getInteger(String.valueOf(p.playerImg.getId())));
                    playerPopUp.show();
                }
            });
        }
        for (PlayerCardBinding p : teamTwoPlayerCardBindings) {
            p.playerCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerPopUp.setContentView(playerStatPopUpBinding.playerStatPopUp) ;
                    playerStatPopUpBinding.playerStatImg.setImageResource(teamOnePlayers.get(1).getImageResId());
                    playerPopUp.show();
                }
            });
        }
    }

}