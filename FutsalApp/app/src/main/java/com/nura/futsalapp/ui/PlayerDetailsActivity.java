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
import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.utils.Const;

public class PlayerDetailsActivity extends AppCompatActivity {

    private static final String TAG = "PlayerDetailsActivity";
    private ActivityPlayerDetailsBinding playerDetailsBinding;

    private Player player;

    private PlayerDetailRefernceBinding ageLayout, gamesLayout, goalsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        playerDetailsBinding = ActivityPlayerDetailsBinding.inflate(getLayoutInflater());
        View view = playerDetailsBinding.getRoot();
        ageLayout = playerDetailsBinding.ageLayout;
        gamesLayout = playerDetailsBinding.gamesLayout;
        goalsLayout = playerDetailsBinding.goalsLayout;
        setContentView(view);
        getIntentData();
    }

    private void getIntentData() {
        try {
            player = getIntent().getParcelableExtra(Const.PLAYER);
            if (player != null) {
                player.resolveImageResId(this);
                setPlayerData();
            }
        } catch (Exception e) {

        }
    }

    private void setPlayerData() {
        ageLayout.playerStatHeading.setText("Age");
        gamesLayout.playerStatHeading.setText("Games");
        goalsLayout.playerStatHeading.setText("Goals");
        ageLayout.playerStatHeadingData.setText("24");
        gamesLayout.playerStatHeadingData.setText("4");
        goalsLayout.playerStatHeadingData.setText("21");
        playerDetailsBinding.playerDetailImage.setImageResource(player.getImageResId());
        playerDetailsBinding.playerDetailName.setText(player.getName());

    }


}