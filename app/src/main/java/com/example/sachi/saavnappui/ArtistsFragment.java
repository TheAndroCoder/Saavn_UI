package com.example.sachi.saavnappui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class ArtistsFragment extends Fragment {
    private GridView gridview;
    private ArrayList<Songs> list2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_radio_artists,container,false);
        gridview=(GridView) v.findViewById(R.id.gridview);
        list2=new ArrayList<>();
        createList() ;
        GridAdapter adapter = new GridAdapter(getActivity(),R.layout.trending_item,list2);
        gridview.setAdapter(adapter);
        return v;
    }
    private void createList(){
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
}
