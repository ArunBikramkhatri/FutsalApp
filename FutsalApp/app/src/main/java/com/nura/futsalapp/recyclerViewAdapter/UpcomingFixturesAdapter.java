package com.nura.futsalapp.recyclerViewAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.model.Fixture;
import com.nura.futsalapp.model.Player;

import java.util.ArrayList;

public class UpcomingFixturesAdapter extends RecyclerView.Adapter<UpcomingFixturesAdapter.ViewHolder> {
    private static final String TAG = "UpcomingFixturesAdapter";
    private ArrayList<Fixture> fixtureArrayList;


    public UpcomingFixturesAdapter(ArrayList<Fixture> fixtureArrayList) {
        this.fixtureArrayList = fixtureArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_fixture_layout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            Player p1 = fixtureArrayList.get(position).getPlayerOne();
            Player p2 = fixtureArrayList.get(position).getPlayerTwo();
            holder.fixtureTeamOne.setText(p1.getName());
            holder.fixtureTeamTwo.setText(p2.getName());
//            holder.fixtureScore.setText(fixtureArrayList.get(position).getScore());
        } catch (Exception e) {
           e.printStackTrace();
            Log.e(TAG, "onBindViewHolder: " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public int getItemCount() {
        return fixtureArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fixtureTeamOne , fixtureTeamTwo , fixtureScore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fixtureTeamOne = itemView.findViewById(R.id.upcomingFixtureTeamOne);
            fixtureTeamTwo = itemView.findViewById(R.id.upcomingFixtureTeamTwo);
//            fixtureScore = itemView.findViewById(R.id.fixtureScore);
        }
    }
}
