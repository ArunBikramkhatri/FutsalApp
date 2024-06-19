package com.nura.futsalapp.recyclerViewAdapter;

import android.app.Activity;
import android.content.Intent;
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
import com.nura.futsalapp.ui.PlayerDetailsActivity;
import com.nura.futsalapp.utils.Const;

import java.util.ArrayList;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.ViewHolder> {

    private static final String TAG = "PlayerListRecyclerViewA";

    private ArrayList<Player> playerArrayList ;

    private Activity activity;
    public PlayerListAdapter(ArrayList<Player> playerArrayList ,Activity activity) {
        this.playerArrayList = playerArrayList;
        this.activity = activity;
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
//            holder.player_rating.setText(String.valueOf(player.getRating()));
            holder.player_list_img.setImageResource(player.getImageResId());

            holder.player_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPlayerDetail(player);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "onBindViewHolder: " + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }

    private void openPlayerDetail(Player player) {
        Intent intent =  new Intent(activity , PlayerDetailsActivity.class);
        intent.putExtra(Const.PLAYER, player);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_from_right , R.anim.no_animation);
    }

    @Override
    public int getItemCount() {
        return playerArrayList.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView player_name, player_position, player_rating;
        private ImageView player_list_img;
        private ConstraintLayout player_detail ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            player_name = itemView.findViewById(R.id.player_name);
            player_position = itemView.findViewById(R.id.player_position);
            player_rating = itemView.findViewById(R.id.player_rating);
            player_list_img = itemView.findViewById(R.id.player_list_img);
            player_detail = itemView.findViewById(R.id.player_detail);
        }
    }
}
