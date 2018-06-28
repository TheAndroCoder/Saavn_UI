package com.example.sachi.saavnappui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListViewAdapter extends ArrayAdapter<Songs> {
    private ArrayList<Songs> list;
    private int resource;
    private Context context;
    public ListViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Songs> list) {
        super(context, resource, list);
        this.context=context;
        this.resource=resource;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(resource,parent,false);
        CircleImageView image = (CircleImageView) v.findViewById(R.id.songpic);
        TextView name =(TextView) v.findViewById(R.id.name);
        TextView desc =(TextView) v.findViewById(R.id.desc);
        image.setImageResource(list.get(position).getImage());
        name.setText(list.get(position).getName());
        desc.setText(list.get(position).getDesc());

        return v;
    }
}
