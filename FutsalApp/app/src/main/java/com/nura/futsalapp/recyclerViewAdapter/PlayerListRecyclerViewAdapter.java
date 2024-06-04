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

public class PlayerListRecyclerViewAdapter extends RecyclerView.Adapter<PlayerListRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "PlayerListRecyclerViewA";

    private ArrayList<Player> playerArrayList ;

    public PlayerListRecyclerViewAdapter(ArrayList<Player> playerArrayList) {
        this.playerArrayList = playerArrayList;
    }

    @NonNull
    @Override
    public PlayerListRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_detail , parent , false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerListRecyclerViewAdapter.ViewHolder holder, int position) {
        try {
            Player player = playerArrayList.get(position);
            holder.playerName.setText(player.getName());
            holder.playerPosition.setText(player.getPosition());
            holder.playerRating.setText(player.getRating());
        } catch (Exception e) {
            Log.e(TAG, "onBindViewHolder: " + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return playerArrayList.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView playerName , playerPosition , playerRating ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            playerPosition = itemView.findViewById(R.id.player_position);
            playerRating = itemView.findViewById(R.id.player_rating);
        }
    }
}
