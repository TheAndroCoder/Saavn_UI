package com.example.sachi.saavnappui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.Collections;

public class HomeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerview_trending,recycler_recommended;
    private ListView listview;
    private ArrayList<Songs> list,list2;
    private ImageView navigation,search,bell,settings,playbtn;
    private Button playnow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerview_trending=(RecyclerView) findViewById(R.id.recycler);
        recycler_recommended=(RecyclerView) findViewById(R.id.recycler_recommended);
        listview=(ListView) findViewById(R.id.listview);
        list=new ArrayList<>();
        list2=new ArrayList<>();
        navigation=(ImageView) findViewById(R.id.navigationbar);
        search=(ImageView) findViewById(R.id.search);
        bell=(ImageView) findViewById(R.id.notifications);
        settings=(ImageView) findViewById(R.id.settings);
        playbtn=(ImageView) findViewById(R.id.playbtn2);
        playnow=(Button) findViewById(R.id.adv);
        setupBottomNavigation();
        //Trending ArrayList Creation
        createTrendingList();
        TrendingRecyclerAdapter adapter = new TrendingRecyclerAdapter(list);
        recyclerview_trending.setLayoutManager(new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recyclerview_trending.setAdapter(adapter);
        //Recommended arrayList creation
        createRecommendedList();
        RecommendedRecyclerAdapter adapter1=new RecommendedRecyclerAdapter(list2);
        recycler_recommended.setLayoutManager(new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recycler_recommended.setAdapter(adapter1);

        //Swipe up panel listview adapter setup
        ListViewAdapter adapter2 = new ListViewAdapter(HomeActivity.this,R.layout.list_view_item,list2);
        listview.setAdapter(adapter2);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomeActivity.this, "Clicked "+list2.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        //Item CLick Listeners Setup
        setupListeners();
    }
    private void setupBottomNavigation(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.BottomNavViewBar);
        BottomNavigationHelper.setupBottomNavView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(HomeActivity.this,this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem= menu.getItem(0);
        menuItem.setChecked(true);
    }
    private void createTrendingList(){
        Songs song1 = new Songs("High Rated Gabru","Written & Sung by Guru Randhawa",R.drawable.highratedgabru);
        list.add(song1);
        Songs song2 = new Songs("Fashion","Written and sung by Guru Randhawa",R.drawable.fashion);
        list.add(song2);
        Songs song3=new Songs("Rap God","Marshall Mathers LP2",R.drawable.rapgod);
        list.add(song3);
        Songs song4 =new Songs("Not Afraid","Recovery",R.drawable.notafraid);
        list.add(song4);
        Songs song5 = new Songs("Never Let you go","Justin Beiber",R.drawable.justin);
        list.add(song5);
    }
    private void createRecommendedList(){
        Songs song1 = new Songs("Shawn Mendes","Unplugged",R.drawable.unplugged);
        list2.add(song1);
        Songs song2 = new Songs("Eminem Top 10","Recovery",R.drawable.eminem_top10);
        list2.add(song2);
        Songs song3=new Songs("Ed Sheeran","Afire Love",R.drawable.sheeran);
        list2.add(song3);
        Songs song4 =new Songs("Kailash Kher","Album",R.drawable.kailash);
        list2.add(song4);
        Songs song5 = new Songs("Never Let you go","Justin Beiber",R.drawable.justin);
        list2.add(song5);
    }
    private void setupListeners(){
        playnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Clicked PLAY NOW", Toast.LENGTH_SHORT).show();
            }
        });
        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Action Bar Drawer Toggle", Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Clicked on Search", Toast.LENGTH_SHORT).show();
            }
        });
        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Clicked on notifications", Toast.LENGTH_SHORT).show();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Clicked settings", Toast.LENGTH_SHORT).show();
            }
        });
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Song playing...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
