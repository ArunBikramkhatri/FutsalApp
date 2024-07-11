package com.nura.futsalapp.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nura.futsalapp.R;
import com.nura.futsalapp.databinding.PointTableRecyclerViewBinding;
import com.nura.futsalapp.model.GoalScorer;
import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.model.PointsTable;
import com.nura.futsalapp.recyclerViewAdapter.GoalScorersAdapter;
import com.nura.futsalapp.recyclerViewAdapter.PointTableAdapter;

import java.util.ArrayList;

public class PointsTableFragment extends Fragment {

    private ArrayList<PointsTable> pointsTableList;

    private PointTableAdapter pointTableAdapter;
    private GoalScorersAdapter goalScorersAdapter;

    PointTableRecyclerViewBinding pointTableBinding;
    private ArrayList<GoalScorer> goalScorers;
    private RecyclerView recyclerView ,goalScorerRecyclerView;

    private Activity activity;
    public PointsTableFragment(Activity activity) {
        pointsTableList = new ArrayList<>();
        pointsTableList.add(new PointsTable(activity,"Mahesh", "4", "0", "1", "12"));
        pointsTableList.add(new PointsTable(activity,"Mever", "4", "0", "1", "12"));
        pointsTableList.add(new PointsTable(activity,"NabinT", "3", "0", "1", "9"));
        pointsTableList.add(new PointsTable(activity,"Ajit", "2", "0", "1", "6"));
        pointsTableList.add(new PointsTable(activity,"Manish", "2", "0", "2", "6"));
        pointsTableList.add(new PointsTable(activity,"Upendra", "1", "0", "1", "3"));
        pointsTableList.add(new PointsTable(activity,"Sujan", "1", "0", "3", "3"));
        pointsTableList.add(new PointsTable(activity,"NabinB", "0", "0", "7", "0"));
        this.activity = activity;


        goalScorers = new ArrayList<>();

        // Adding data from the provided list
        goalScorers.add(new GoalScorer(activity, "NabinT", 34));
        goalScorers.add(new GoalScorer(activity, "Mever", 31));
        goalScorers.add(new GoalScorer(activity, "Ajit", 25));
        goalScorers.add(new GoalScorer(activity, "Mahesh", 19));
        goalScorers.add(new GoalScorer(activity, "Jenish", 18));
        goalScorers.add(new GoalScorer(activity, "Upendra", 13));
        goalScorers.add(new GoalScorer(activity, "Sujan", 13));
        goalScorers.add(new GoalScorer(activity, "Veen", 11));
        goalScorers.add(new GoalScorer(activity, "Arun", 9));
        goalScorers.add(new GoalScorer(activity, "NabinB", 6));
        goalScorers.add(new GoalScorer(activity, "Summer", 5));
        goalScorers.add(new GoalScorer(activity, "Sumanta", 5));
        goalScorers.add(new GoalScorer(activity, "Jagadish", 4));
        goalScorers.add(new GoalScorer(activity, "Ashwin", 3));
        goalScorers.add(new GoalScorer(activity, "Sudip", 2));
        goalScorers.add(new GoalScorer(activity, "Showan", 1));
        goalScorers.add(new GoalScorer(activity, "Anil", 1));
        goalScorers.add(new GoalScorer(activity, "Pushkar", 1));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pointTableBinding = PointTableRecyclerViewBinding.inflate(getLayoutInflater());
        View view = pointTableBinding.getRoot();

        recyclerView =  view.findViewById(R.id.point_table_recycle);
        goalScorerRecyclerView = pointTableBinding.recyclerGoalScorers;


        pointTableAdapter = new PointTableAdapter(pointsTableList);
        goalScorersAdapter = new GoalScorersAdapter(goalScorers);

        recyclerView.setAdapter(pointTableAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        goalScorerRecyclerView.setAdapter(goalScorersAdapter);
        goalScorerRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        return view;
    }
}