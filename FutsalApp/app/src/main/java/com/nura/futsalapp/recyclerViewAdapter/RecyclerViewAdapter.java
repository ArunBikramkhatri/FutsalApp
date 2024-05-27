package com.nura.futsalapp.recyclerViewAdapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.model.Player;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    ArrayList<Player> playerArrayList ;


    public RecyclerViewAdapter(ArrayList<Player> playerArrayList) {
        this.playerArrayList = playerArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_card , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.playerName.setText(playerArrayList.get(position).getName());

        holder.playerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + playerArrayList.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return playerArrayList.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder{

        private TextView playerName ;
        private ImageView imageView;

        private ConstraintLayout playerCard ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_card_name);
            playerCard = itemView.findViewById(R.id.player_card);
//            playerRating = itemView.findViewById(R.id.player_rating);
//            playerPosition = itemView.findViewById(R.id.player_position);
        }
    }
}
