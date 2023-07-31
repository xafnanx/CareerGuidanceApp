package com.example.careerapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.careerapp.R;
import com.example.careerapp.model.aoiModel;

import java.util.ArrayList;


public class AoiRecycleViewAdapter extends RecyclerView.Adapter<AoiRecycleViewAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<aoiModel> mExampleList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AoiRecycleViewAdapter(Context context, ArrayList<aoiModel> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        aoiModel currentItem = mExampleList.get(position);

        String careerName = currentItem.getCareerName();
        String careerDescription = currentItem.getCareerDescription();
        String careerUrl = currentItem.getCareerUrl();

        holder.career_Name.setText(careerName);
//        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView career_Name;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            career_Name = itemView.findViewById(R.id.career_Name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
