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
            holder.teamOneName.setText(fixture.getPlayerOne().getNickName());
            holder.teamTwoName.setText(fixture.getPlayerTwo().getNickName());
            holder.score.setText(fixture.getScore());
            holder.gameWeek.setText("GameWeek " + (position+1));
            holder.teamOneLogo.setImageResource(fixture.getPlayerOne().getTeamLogoId());
            holder.teamTwoLogo.setImageResource(fixture.getPlayerTwo().getTeamLogoId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return fixtureArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView teamOneName , teamTwoName,  score , gameWeek;
        private ImageView teamOneLogo , teamTwoLogo ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameWeek = itemView.findViewById(R.id.gameWeek);
            teamOneName = itemView.findViewById(R.id.pastFixtureTeamOne) ;
            teamTwoName = itemView.findViewById(R.id.pastFixtureTeamTwo) ;
            score = itemView.findViewById(R.id.textView2);
            teamOneLogo = itemView.findViewById(R.id.teamOneLogo);
            teamTwoLogo = itemView.findViewById(R.id.teamTwoLogo);
        }
    }
}
