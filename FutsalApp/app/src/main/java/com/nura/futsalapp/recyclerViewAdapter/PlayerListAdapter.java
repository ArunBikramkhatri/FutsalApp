package com.nura.futsalapp.recyclerViewAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.model.Player;

import java.util.ArrayList;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.ViewHolder> {

    private static final String TAG = "PlayerListRecyclerViewA";

    private ArrayList<Player> playerArrayList ;

    public PlayerListAdapter(ArrayList<Player> playerArrayList) {
        this.playerArrayList = playerArrayList;
    }

    @NonNull
    @Override
    public PlayerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_detail , parent , false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerListAdapter.ViewHolder holder, int position) {
        try {
            Player player = playerArrayList.get(position);
            holder.player_name.setText(player.getName());
            holder.player_position.setText(player.getPosition());
            holder.player_rating.setText(String.valueOf(player.getRating()));
            holder.player_list_img.setImageResource(player.getImageResId());
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

        private TextView player_name, player_position, player_rating;
        private ImageView player_list_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            player_name = itemView.findViewById(R.id.player_name);
            player_position = itemView.findViewById(R.id.player_position);
            player_rating = itemView.findViewById(R.id.player_rating);
            player_list_img = itemView.findViewById(R.id.player_list_img);
        }
    }
}
