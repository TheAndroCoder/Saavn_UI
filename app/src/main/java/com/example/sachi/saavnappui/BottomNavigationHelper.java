package com.example.sachi.saavnappui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationHelper {
    public static void setupBottomNavView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(true);

    }
    public static void enableNavigation(final Context context, final Activity callingActivity, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.ic_home :
                        context.startActivity(new Intent(context, HomeActivity.class));
                        break;
                    case R.id.radio :
                        context.startActivity(new Intent(context,RadioActivity.class));
                        break;
                    case R.id.browse :
                        context.startActivity(new Intent(context,BrowseActivity.class));
                        break;
                    case R.id.mymusic :
                        context.startActivity(new Intent(context,MyMusicActivity.class));
                        break;


                }
                return false;
            }
        });
    }
}
