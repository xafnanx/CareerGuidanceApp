package com.example.careerapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.careerapp.R;
import com.example.careerapp.activities.CollageDetail;
import com.example.careerapp.model.collageModel;

import java.util.List;

public class ClgRecyclerViewAdapter extends RecyclerView.Adapter<ClgRecyclerViewAdapter.CollageViewHolder> {

    private Context mContext;
    private List<collageModel> mData;
    RequestOptions option;

    public ClgRecyclerViewAdapter(Context mContext, List<collageModel> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for Glide
        option = new RequestOptions().fitCenter().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public CollageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.collage_row_item,parent,false);
        CollageViewHolder viewHolder = new CollageViewHolder(view);
        viewHolder.viewContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, CollageDetail.class);
                i.putExtra("Name",mData.get(viewHolder.getAdapterPosition()).getClgName());
                i.putExtra("Location",mData.get(viewHolder.getAdapterPosition()).getClgLocation());
                i.putExtra("Rating",mData.get(viewHolder.getAdapterPosition()).getClg_Rating());
                i.putExtra("Logo",mData.get(viewHolder.getAdapterPosition()).getClgLogo());
                i.putExtra("Website",mData.get(viewHolder.getAdapterPosition()).getClgWebsite());
                i.putExtra("Description",mData.get(viewHolder.getAdapterPosition()).getClgDescription());
                i.putExtra("Pic",mData.get(viewHolder.getAdapterPosition()).getClgPic());

                mContext.startActivity(i);

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CollageViewHolder holder, int position) {
        holder.clg_Name.setText(mData.get(position).getClgName());
        holder.clg_Location.setText(mData.get(position).getClgLocation());
        holder.clg_Rating.setText(mData.get(position).getClg_Rating());

        //Load Image from the internet and set into ImageView using Glide

        Glide.with(mContext).load(mData.get(position).getClgLogo()).apply(option).into(holder.clg_Logo);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class CollageViewHolder extends RecyclerView.ViewHolder {
        TextView clg_Name,clg_Location,clg_Rating;
        ImageView clg_Logo;
        LinearLayout viewContainer;

        public CollageViewHolder(@NonNull View itemView) {
            super(itemView);

            viewContainer = itemView.findViewById(R.id.clg_container);
            clg_Name = itemView.findViewById(R.id.clg_Name);
            clg_Location = itemView.findViewById(R.id.clg_Location);
            clg_Rating = itemView.findViewById(R.id.clg_Rating);
            clg_Logo = itemView.findViewById(R.id.clg_Logo);

        }
    }
}
