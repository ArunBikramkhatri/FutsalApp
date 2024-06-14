package com.nura.futsalapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.nura.futsalapp.R;
import com.nura.futsalapp.databinding.ActivityPlayerDetailsBinding;
import com.nura.futsalapp.databinding.PlayerDetailBinding;
import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.utils.Const;

public class PlayerDetailsActivity extends AppCompatActivity {

    private ActivityPlayerDetailsBinding playerDetailsBinding;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerDetailsBinding = ActivityPlayerDetailsBinding.inflate(getLayoutInflater());
        View view = playerDetailsBinding.getRoot();
        setContentView(view);
        getIntentData();
    }

    private void getIntentData() {
        try {
            player = getIntent().getParcelableExtra(Const.PLAYER);
            if (player != null){
                playerDetailsBinding.playerName.setText(player.getName());
            }
        }catch (Exception e){

        }
    }


}