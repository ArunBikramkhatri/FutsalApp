package com.nura.futsalapp.recyclerViewAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.databinding.PointTableRecyclerViewBinding;
import com.nura.futsalapp.model.GoalScorer;
import com.nura.futsalapp.model.PointsTable;

import java.util.ArrayList;

public class GoalScorersAdapter  extends RecyclerView.Adapter<GoalScorersAdapter.ViewHolder> {
    private static final String TAG = "PastFixturesAdapter";
    private ArrayList<GoalScorer> goalScorers;

    public GoalScorersAdapter(ArrayList<GoalScorer> goalScorers) {
        this.goalScorers = goalScorers;
    }

    @NonNull
    @Override
    public GoalScorersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goal_scorers , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            GoalScorer scorer = goalScorers.get(position);
            holder.name.setText(scorer.getName());
            holder.goals.setText(String.valueOf(scorer.getGoals()));
            holder.img.setImageResource(scorer.getImgId());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

//    @Override
//    public void onBindViewHolder(@NonNull PastFixturesAdapter.ViewHolder holder, int position) {
//        try {
//            Fixture fixture = fixtureArrayList.get(position);
//            Log.d(TAG, "onBindViewHolder: " + fixture.toString());
//            holder.teamOneName.setText(fixture.getPlayerOne().getNickName());
//            holder.teamTwoName.setText(fixture.getPlayerTwo().getNickName());
//            holder.score.setText(fixture.getScore());
//            holder.teamOneLogo.setImageResource(fixture.getPlayerOne().getTeamLogoId());
//            holder.teamTwoLogo.setImageResource(fixture.getPlayerTwo().getTeamLogoId());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public int getItemCount() {
        return goalScorers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name , goals;
        private ImageView img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.goalScorerName);
            img = itemView.findViewById(R.id.goalScorerPhoto);
            goals = itemView.findViewById(R.id.goalScored);
        }
    }
}