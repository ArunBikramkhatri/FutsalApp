package com.nura.futsalapp;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nura.futsalapp.data.PlayingPlayers;
import com.nura.futsalapp.dto.FixtureListDTO;
import com.nura.futsalapp.model.Fixture;
import com.nura.futsalapp.model.PlayersList;
import com.nura.futsalapp.data.PlayerData;
import com.nura.futsalapp.recyclerViewAdapter.UpcomingFixturesAdapter;
import com.nura.futsalapp.ui.FixturesFragment;
import com.nura.futsalapp.ui.PlayerListFragment;
import com.nura.futsalapp.ui.TeamFormationFragment;
import com.nura.futsalapp.utils.DeviceInfo;
import com.nura.futsalapp.viewpager.ViewPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ViewPager2 appViewPager;


    private BottomNavigationView bottomNav;
    ViewPagerAdapter viewPagerAdapter;

    private PlayersList allPlayers;
    public PlayersList playingPlayers;
    private FixtureListDTO fixtures;

    private UpcomingFixturesAdapter upcomingFixturesAdapter;
    private ArrayList<Fixture> fixtureArrayList;
    private MainOperations mainOperations;
    private static MainActivity mInstance;

    public MainActivity() {
    }

    public static MainActivity getInstance() {
        if (mInstance == null){
            mInstance =  new MainActivity();
        }
        return mInstance;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_view_pager);
        WindowInsetsControllerCompat windowInsetsControllerCompat = WindowCompat.getInsetsController(getWindow() ,getWindow().getDecorView());
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try {
            initPlayerData();
            initFields();
            initFixturesRecyclerData();
            initPlayingPlayers();
            viewPagerAdapter = new ViewPagerAdapter(this);
            addFragments();
            appViewPager.setAdapter(viewPagerAdapter);
        } catch (Exception e) {
            Log.e(TAG, "onCreate: " + e.getLocalizedMessage(), e);
            e.printStackTrace();
        }
    }

    private void initFields() {
        bottomNav = findViewById(R.id.bottomNav);
        appViewPager = findViewById(R.id.app_view_pager);
    }

    private void utilsTest() {
        DeviceInfo deviceInfo = new DeviceInfo();
        String version = deviceInfo.getAndroidVersion();
        Log.d(TAG, "utilsTest: " + version);

    }

    private void addFragments() {
        viewPagerAdapter.addFragments(new FixturesFragment(this, fixtureArrayList));
        viewPagerAdapter.addFragments(new TeamFormationFragment(this, playingPlayers));
        viewPagerAdapter.addFragments(new PlayerListFragment(this, allPlayers.getPlayers()));
    }

    private void initPlayerData() {
        PlayerData playerData = new PlayerData();
        String playerJson = playerData.getPlayerData();
        allPlayers = MainOperations.initPlayerData(this, playerJson);

    }

    private void initFixturesRecyclerData() {
        fixtureArrayList = MainOperations.initFixturesRecyclerData(allPlayers ,this);
    }


    public void initPlayingPlayers() {
        String playingPlayersJson = PlayingPlayers.getPlayingPlayers();
        playingPlayers = MainOperations.initPlayerData(this, playingPlayersJson);
    }

}
