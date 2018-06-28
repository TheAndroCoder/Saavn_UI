package com.example.sachi.saavnappui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MyMusicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymusic);
        setupBottomNavigation();
    }
    private void setupBottomNavigation(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.BottomNavViewBar);
        BottomNavigationHelper.setupBottomNavView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(MyMusicActivity.this,this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem= menu.getItem(3);
        menuItem.setChecked(true);
    }
}
