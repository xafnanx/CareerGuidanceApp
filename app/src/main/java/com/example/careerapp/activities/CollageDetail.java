package com.example.careerapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.careerapp.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CollageDetail extends AppCompatActivity {
    RequestOptions option;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collage_detail);
        option = new RequestOptions().centerCrop().placeholder(R.drawable.lavender_background).error(R.drawable.lavender_background);

        //receive data
        String Name = getIntent().getExtras().getString("Name");
        String Description = getIntent().getExtras().getString("Description");
        String Location = getIntent().getExtras().getString("Location");
        String Logo = getIntent().getExtras().getString("Logo");
        String Website = getIntent().getExtras().getString("Website");
        String Pic = getIntent().getExtras().getString("Pic");
        int Rating = getIntent().getExtras().getInt("Rating");

        //init views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.clg_collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView clg_Name = findViewById(R.id.clg_Name);
        TextView clg_Location = findViewById(R.id.clg_Location);
        //TextView clg_Rating = findViewById(R.id.clg_Rating);
        TextView clg_Description = findViewById(R.id.clg_Description);
        TextView clg_Website = findViewById(R.id.clg_Website);
        ImageView clg_Logo = findViewById(R.id.clg_Logo);
        ImageView clg_Pic = findViewById(R.id.clg_Pic);

        //setting values to each view
        clg_Name.setText(Name);
        clg_Location.setText(Location);
//      clg_Rating.setText(Rating);
        clg_Description.setText(Description);

        collapsingToolbarLayout.setTitle(Name);


        //set image using Glide
        Glide.with(this).load(Logo).into(clg_Logo);
        Glide.with(this).load(Pic).apply(option).into(clg_Pic);

        clg_Website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl(Website);
            }
        });

    }

    private void gotoUrl(String website) {
        Uri uri = Uri.parse(website);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}