package com.nura.futsalapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.nura.futsalapp.R;
import com.nura.futsalapp.databinding.ActivityPlayerDetailsBinding;
import com.nura.futsalapp.databinding.PlayerDetailBinding;
import com.nura.futsalapp.databinding.PlayerDetailRefernceBinding;
import com.nura.futsalapp.databinding.PlayerRatingProgressBinding;
import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.utils.Const;

public class PlayerDetailsActivity extends AppCompatActivity {

    private static final String TAG = "PlayerDetailsActivity";
    private ActivityPlayerDetailsBinding playerDetailsBinding;

    private Player player;

    private PlayerDetailRefernceBinding ageLayout, gamesLayout, goalsLayout;
    PlayerRatingProgressBinding overallRating, pace, shooting, passing, dribbling, defence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        playerDetailsBinding = ActivityPlayerDetailsBinding.inflate(getLayoutInflater());
        View view = playerDetailsBinding.getRoot();
        ageLayout = playerDetailsBinding.ageLayout;
        gamesLayout = playerDetailsBinding.gamesLayout;
        goalsLayout = playerDetailsBinding.goalsLayout;
        overallRating = playerDetailsBinding.overall;
        setContentView(view);
        getIntentData();
    }

    private void getIntentData() {
        try {
            player = getIntent().getParcelableExtra(Const.PLAYER);
            if (player != null) {
                Log.d(TAG, "getIntentData: " + player.toString());
                player.setCaptain(true);
                player.resolveImageResId(this);
                setPlayerData(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setLayoutDetail() {
        ageLayout.playerStatHeading.setText("Age");
        gamesLayout.playerStatHeading.setText("Games");
        goalsLayout.playerStatHeading.setText("Goals");
        overallRating.statProgressName.setText("Overall");
        pace.statProgressName.setText("Pace");
        shooting.statProgressName.setText("Shooting");
        passing.statProgressName.setText("Passing");
        dribbling.statProgressName.setText("Dribbling");
        defence.statProgressName.setText("Defence");
    }

    private void setPlayerData(Player player) {

        ageLayout.playerStatHeadingData.setText("24");
        gamesLayout.playerStatHeadingData.setText("4");
        goalsLayout.playerStatHeadingData.setText("21");

        playerDetailsBinding.playerDetailImage.setImageResource(player.getImageResId());
        playerDetailsBinding.playerDetailName.setText(player.getName());

        if (player.getTeamLogoId() == 0) {

        } else {
            playerDetailsBinding.teamLogo.setImageResource(player.getTeamLogoId());
        }
        setFootballRating();
    }


    public void setFootballRating() {
        int x = 90;
        overallRating.playerRatingProgress.setProgress(x);
        overallRating.playerRatingProgressText.setText(x);

        pace.playerRatingProgress.setProgress(x);
        pace.playerRatingProgressText.setText(x);

        shooting.playerRatingProgress.setProgress(x);
        shooting.playerRatingProgressText.setText(x);

        passing.playerRatingProgress.setProgress(x);
        passing.playerRatingProgressText.setText(x);

        dribbling.playerRatingProgress.setProgress(x);
        dribbling.playerRatingProgressText.setText(x);

        defence.playerRatingProgress.setProgress(x);
        defence.playerRatingProgressText.setText(x);
    }
}