package com.example.sachi.saavnappui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrendingRecyclerAdapter extends RecyclerView.Adapter<TrendingRecyclerAdapter.MyViewHolder> {
    ArrayList<Songs> list;
    public TrendingRecyclerAdapter(ArrayList<Songs> list){
        this.list=list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Clicked "+list.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public RoundedImageView image;
        public TextView name,desc;
        public MyViewHolder(View v){
            super(v);
            image=(RoundedImageView) v.findViewById(R.id.imageview);
            name=(TextView) v.findViewById(R.id.name);
            desc=(TextView) v.findViewById(R.id.desc);
        }
    }
}
