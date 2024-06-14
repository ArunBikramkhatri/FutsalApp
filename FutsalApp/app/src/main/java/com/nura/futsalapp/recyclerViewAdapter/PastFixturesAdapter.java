package com.nura.futsalapp.recyclerViewAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.databinding.PastFixturesLayoutBinding;
import com.nura.futsalapp.model.Fixture;

import java.util.ArrayList;

public class PastFixturesAdapter  extends RecyclerView.Adapter<PastFixturesAdapter.ViewHolder> {
    private static final String TAG = "PastFixturesAdapter";
    private ArrayList<Fixture> fixtureArrayList;

    private PastFixturesLayoutBinding pastFixtureBinding;
    public PastFixturesAdapter(ArrayList<Fixture> fixtureArrayList) {
        this.fixtureArrayList = fixtureArrayList;
    }

    @NonNull
    @Override
    public PastFixturesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.past_fixtures_layout , parent , false);
        pastFixtureBinding = PastFixturesLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PastFixturesAdapter.ViewHolder holder, int position) {
        try {
            Fixture fixture = fixtureArrayList.get(position);
            Log.d(TAG, "onBindViewHolder: " + fixture.toString());
            holder.teamOneName.setText(fixture.getPlayerOne().getName());
            holder.teamTwoName.setText(fixture.getPlayerTwo().getName());
            holder.score.setText(fixture.getScore());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return fixtureArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView teamOneName , teamTwoName,  score ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamOneName = itemView.findViewById(R.id.pastFixtureTeamOne) ;
            teamTwoName = itemView.findViewById(R.id.pastFixtureTeamTwo) ;
            score = itemView.findViewById(R.id.textView2);
        }
    }
}
