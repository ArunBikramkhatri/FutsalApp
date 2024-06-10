package com.nura.futsalapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.model.Fixture;
import com.nura.futsalapp.recyclerViewAdapter.FixturesAdapter;

import java.util.ArrayList;

public class FixturesFragment extends Fragment {

    private RecyclerView fixturesRecycler;
    private FixturesAdapter fixturesAdapter;
    private Activity activity;
    private ArrayList<Fixture> fixtureArrayList;

    public FixturesFragment(Activity activity, ArrayList<Fixture> fixtureArrayList) {
        this.activity = activity;
        this.fixtureArrayList = fixtureArrayList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fixtures_recycler , container, false);
        fixturesRecycler = view.findViewById(R.id.fixturesRecycler);
        fixturesAdapter = new FixturesAdapter(fixtureArrayList);
        fixturesRecycler.setAdapter(fixturesAdapter);
        fixturesRecycler.setLayoutManager(new LinearLayoutManager(activity));
        return view;
    }


}
