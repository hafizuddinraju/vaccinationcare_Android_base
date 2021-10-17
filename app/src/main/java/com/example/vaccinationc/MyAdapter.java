package com.example.vaccinationc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<campaigndata>campaigndataArrayList;

    public MyAdapter(Context context, ArrayList<campaigndata> campaigndataArrayList) {
        this.context = context;
        this.campaigndataArrayList = campaigndataArrayList;
    }

    @NonNull

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {

        campaigndata cam = campaigndataArrayList.get(position);
        holder.vaccine.setText(cam.vaccine);
        holder.startage.setText(cam.startage);
        holder.endage.setText(cam.endage);
        holder.date.setText(cam.date);
        holder.price.setText(cam.price);
        holder.place.setText(cam.place);

    }

    @Override
    public int getItemCount() {
        return campaigndataArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView vaccine ,startage, endage, date, price, place;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            vaccine = itemView.findViewById(R.id.vaccinenameid);
            startage = itemView.findViewById(R.id.vaccinestartageid);
            endage = itemView.findViewById(R.id.vaccineendageid);
            date = itemView.findViewById(R.id.vaccinedateid);
            price = itemView.findViewById(R.id.vaccinepriceid);
            place = itemView.findViewById(R.id.vaccineplaceid);
        }
    }
}
