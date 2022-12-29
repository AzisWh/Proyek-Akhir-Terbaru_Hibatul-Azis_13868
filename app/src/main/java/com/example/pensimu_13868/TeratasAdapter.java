package com.example.pensimu_13868;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeratasAdapter extends RecyclerView.Adapter<TeratasAdapter.TeratasViewHolder> {

    Context context;
    List<RecentDuaData> TeratasDataList;

    public TeratasAdapter(Context context, List<RecentDuaData> teratasDataList) {
        this.context = context;
        this.TeratasDataList = teratasDataList;
    }

    @NonNull
    @Override
    public TeratasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recent_row_item2, parent, false);
        return new TeratasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeratasViewHolder holder, int position) {

        holder.konserName.setText(TeratasDataList.get(position).getKonserName());
        holder.konserPlace.setText(TeratasDataList.get(position).getPlaceName());
        holder.price.setText(TeratasDataList.get(position).getPrice());
        holder.placeImage.setImageResource(TeratasDataList.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return TeratasDataList.size();
    }

    public static final class TeratasViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView konserName, konserPlace, price;

        public TeratasViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.konser_image);
            konserName = itemView.findViewById(R.id.nama_konser);
            konserPlace = itemView.findViewById(R.id.tempat_konser);
            price = itemView.findViewById(R.id.harga_konser);


        }
    }
}

