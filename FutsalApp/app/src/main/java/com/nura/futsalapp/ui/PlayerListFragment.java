package com.nura.futsalapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nura.futsalapp.R;
import com.nura.futsalapp.model.Player;
import com.nura.futsalapp.model.PlayersList;
import com.nura.futsalapp.recyclerViewAdapter.PlayerListAdapter;
import com.nura.futsalapp.utils.Utils;

import java.util.ArrayList;

public class PlayerListFragment extends Fragment {

    private static final String TAG = "PlayerListFragment";
    private RecyclerView recyclerView ;
    private PlayerListAdapter recyclerViewAdapter;
    private ArrayList<Player> players ;
    private Activity activity ;

    public PlayerListFragment(Activity activity , ArrayList<Player> players) {
        this.activity = activity;
        this.players = players;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        initRecyclerAdapter();
        View view = inflater.inflate(R.layout.player_list_recycler,container , false);
        recyclerView = view.findViewById(R.id.player_recycler_list);
        recyclerViewAdapter = new PlayerListAdapter(players, this.activity);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        return view ;
    }


}
