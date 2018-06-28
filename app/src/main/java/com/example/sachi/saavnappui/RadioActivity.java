package com.example.sachi.saavnappui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class RadioActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewpager;
    private TabLayout tablayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        viewpager=(ViewPager) findViewById(R.id.viewpager);
        setSupportActionBar(toolbar);
        tablayout=(TabLayout) findViewById(R.id.tablayout);


        setupBottomNavigation();
        setupViewPager();
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setText("FEATURED");
        tablayout.getTabAt(1).setText("ARTISTS");
    }
    private void setupViewPager(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragments(new FeaturedFragment());
        adapter.addFragments(new ArtistsFragment());
        viewpager.setAdapter(adapter);
    }
    private void setupBottomNavigation(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.BottomNavViewBar);
        BottomNavigationHelper.setupBottomNavView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(RadioActivity.this,this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem= menu.getItem(1);
        menuItem.setChecked(true);
    }
}
