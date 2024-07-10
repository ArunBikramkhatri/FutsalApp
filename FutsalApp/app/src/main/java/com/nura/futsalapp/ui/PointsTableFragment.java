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
import com.nura.futsalapp.model.PointsTable;
import com.nura.futsalapp.recyclerViewAdapter.PointTableAdapter;

import java.util.ArrayList;

public class PointsTableFragment extends Fragment {

    private ArrayList<PointsTable> pointsTableList;

    private PointTableAdapter pointTableAdapter;

    PointTableRecyclerViewBinding pointTableBinding;
    private RecyclerView recyclerView;

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
        pointTableAdapter = new PointTableAdapter(pointsTableList);

        recyclerView.setAdapter(pointTableAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        return view;
    }
}