package com.example.sachi.saavnappui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class FeaturedFragment extends Fragment {
    private GridView gridview;
    private ArrayList<Songs> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_radio_featured,container,false);
        gridview=(GridView) v.findViewById(R.id.gridview);
        list=new ArrayList<>();
        createList() ;
        GridAdapter adapter = new GridAdapter(getActivity(),R.layout.trending_item,list);
        gridview.setAdapter(adapter);
        return v;
    }
    private void createList(){
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
}
