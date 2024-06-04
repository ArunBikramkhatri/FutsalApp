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
import com.nura.futsalapp.recyclerViewAdapter.PlayerListRecyclerViewAdapter;
import com.nura.futsalapp.utils.Utils;

public class PlayerListFragment extends Fragment {

    private static final String TAG = "PlayerListFragment";
    private RecyclerView recyclerView ;
    private PlayerListRecyclerViewAdapter recyclerViewAdapter;

    private Activity activity ;

    public PlayerListFragment(Activity activity) {
        this.activity = activity;
    }

    String forwards = "[\n" +
            "    {\"name\": \"Lionel Messi\", \"rating\": 8, \"position\": \"ST\"},\n" +
            "    {\"name\": \"Cristiano Ronaldo\", \"rating\": 8, \"position\": \"ST\"},\n" +
            "    {\"name\": \"Neymar Jr\", \"rating\": 8, \"position\": \"ST\"},\n" +
            "    {\"name\": \"Kylian Mbappe\", \"rating\": 7, \"position\": \"ST\"},\n" +
            "    {\"name\": \"Robert Lewandowski\", \"rating\": 9, \"position\": \"ST\"},\n" +
            "    {\"name\": \"Kevin De Bruyne\", \"rating\": 9, \"position\": \"MF\"},\n" +
            "    {\"name\": \"Virgil van Dijk\", \"rating\": 8, \"position\": \"DF\"},\n" +
            "    {\"name\": \"Mohamed Salah\", \"rating\": 8, \"position\": \"FW\"},\n" +
            "    {\"name\": \"Sergio Ramos\", \"rating\": 7, \"position\": \"DF\"},\n" +
            "    {\"name\": \"Alisson Becker\", \"rating\": 8, \"position\": \"GK\"},\n" +
            "    {\"name\": \"Sadio Mane\", \"rating\": 8, \"position\": \"FW\"},\n" +
            "    {\"name\": \"Joshua Kimmich\", \"rating\": 7, \"position\": \"MF\"},\n" +
            "    {\"name\": \"Erling Haaland\", \"rating\": 8, \"position\": \"ST\"},\n" +
            "    {\"name\": \"Harry Kane\", \"rating\": 8, \"position\": \"ST\"}\n" +
            "]\n";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        initRecyclerAdapter();
        View view = inflater.inflate(R.layout.player_list ,container , false);
        recyclerView = view.findViewById(R.id.player_recycler_list);
        recyclerViewAdapter = new PlayerListRecyclerViewAdapter(Utils.getListPlayer(forwards));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        return view ;
    }



    //    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.player_list);
//
//        initRecyclerAdapter();
//    }
//
//    private void initRecyclerAdapter() {
//        Log.d(TAG, "initRecyclerAdapter: ");
//        recyclerView = activity.findViewById(R.id.player_recycler_list);
//        recyclerViewAdapter = new PlayerListRecyclerViewAdapter(Utils.getListPlayer(forwards));
//        recyclerView.setAdapter(recyclerViewAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
//    }
}
