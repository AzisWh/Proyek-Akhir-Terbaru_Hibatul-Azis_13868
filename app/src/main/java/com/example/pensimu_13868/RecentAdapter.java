package com.example.pensimu_13868;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.RecentsViewHolder>{
    Context context;
    List<RecentData> recentDataList;

    public RecentAdapter(Context context, List<RecentData> recentDataList) {
        this.context = context;
        this.recentDataList = recentDataList;
    }

    public RecentAdapter(MenuActivity context, RecentData modelProduct, FloatingActionButton floatingActionButton) {
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recent_row_item, parent, false);
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {



        holder.konserName.setText(recentDataList.get(position).getKonserName());
        holder.konserPlace.setText(recentDataList.get(position).getPlaceName());
        holder.price.setText(recentDataList.get(position).getPrice());
        holder.placeImage.setImageResource(recentDataList.get(position).getImageUrl());

    }

    private void addToCart(String name, String image, String price) {
    }

    @Override
    public int getItemCount() {
        return recentDataList.size();
    }

    //searchbar eror awokawok
    public void filterList(ArrayList<RecentData> filteredList) {
        ArrayList<RecentData> RecentData = filteredList;
        notifyDataSetChanged();
    }

    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView konserName, konserPlace, price;


        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.konser_image);
            konserName = itemView.findViewById(R.id.nama_konser);
            konserPlace = itemView.findViewById(R.id.tempat_konser);
            price = itemView.findViewById(R.id.harga_konser);

        }
    }
}

