package com.nura.futsalapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.model.Fixture;
import com.nura.futsalapp.recyclerViewAdapter.PastFixturesAdapter;
import com.nura.futsalapp.recyclerViewAdapter.UpcomingFixturesAdapter;

import java.util.ArrayList;

public class FixturesFragment extends Fragment {
    private static final String TAG = "FixturesFragment";
    private RecyclerView upcomingFixturesRecycler, pastFixturesRecycler ;
    private UpcomingFixturesAdapter upcomingFixturesAdapter;
    private PastFixturesAdapter pastFixturesAdapter ;
    private Activity activity;
    private ArrayList<Fixture> fixtureArrayList;
    private ArrayList<Fixture> upComingFixtures ;
    private ArrayList<Fixture> pastFixtures ;

    public FixturesFragment(Activity activity, ArrayList<Fixture> fixtureArrayList) {
        this.activity = activity;
        this.fixtureArrayList = fixtureArrayList;
        setFixtures();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fixtures_recycler , container, false);
        upcomingFixturesRecycler = view.findViewById(R.id.upcomingFixturesRecycler);
        pastFixturesRecycler = view.findViewById(R.id.pastFixturesRecycler);

        upcomingFixturesAdapter = new UpcomingFixturesAdapter(upComingFixtures);
        pastFixturesAdapter = new PastFixturesAdapter(pastFixtures);

        upcomingFixturesRecycler.setAdapter(upcomingFixturesAdapter);
        upcomingFixturesRecycler.setLayoutManager(new LinearLayoutManager(activity));

        pastFixturesRecycler.setAdapter(pastFixturesAdapter);
        pastFixturesRecycler.setLayoutManager(new LinearLayoutManager(activity , LinearLayoutManager.HORIZONTAL, false));
        return view;
    }


    private void setFixtures(){
        upComingFixtures = new ArrayList<>();
        pastFixtures = new ArrayList<>();
        try {
            for (Fixture fixture : fixtureArrayList){
                if (fixture.getScore().equals("-")){
                    upComingFixtures.add(fixture);
                    Log.d(TAG, "setFixtures: " + fixture.toString());
                }else {
                    pastFixtures.add(fixture);
                    Log.d(TAG, "setFixtures: " + fixture.toString());
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "setFixtures: ", e);
            e.printStackTrace();
        }
    }
}
