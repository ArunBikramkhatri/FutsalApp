package com.nura.futsalapp.recyclerViewAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_detail , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.playerName.setText(playerArrayList.get(position).getName());
        holder.playerRating.setText(playerArrayList.get(position).getRating());
        holder.playerPosition.setText(playerArrayList.get(position).getPosition());
    }

    @Override
    public int getItemCount() {
        return playerArrayList.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder{

        private TextView playerName,  playerRating ,playerPosition ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            playerRating = itemView.findViewById(R.id.player_rating);
            playerPosition = itemView.findViewById(R.id.player_position);
        }
    }
}
