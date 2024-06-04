package com.nura.futsalapp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nura.futsalapp.ui.PlayerListFragment;
import com.nura.futsalapp.ui.TeamFormationFragment;
import com.nura.futsalapp.utils.DeviceInfo;
import com.nura.futsalapp.viewpager.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ViewPager2 appViewPager;
    private BottomNavigationView bottomNav ;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_view_pager);
        try {
            initFields();
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
       String version =  deviceInfo.getAndroidVersion();
        Log.d(TAG, "utilsTest: " + version);

    }

    private void addFragments(){
        viewPagerAdapter.addFragments(new PlayerListFragment(this));
        viewPagerAdapter.addFragments(new TeamFormationFragment(this));
    }
}
