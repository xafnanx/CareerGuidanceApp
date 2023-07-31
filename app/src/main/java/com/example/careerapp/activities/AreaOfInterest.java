package com.example.careerapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.careerapp.R;
import com.example.careerapp.activities.AoiMain;

public class AreaOfInterest extends AppCompatActivity implements View.OnClickListener {

    TextView social,aesthetic,engineering,medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_of_interest);

        // Initialization of layout elements
        social = findViewById(R.id.social);
        aesthetic = findViewById(R.id.aesthetic);
        engineering = findViewById(R.id.engineering);
        medicine = findViewById(R.id.medicine);

        //Add a listener to Cards
        social.setOnClickListener(this);
        aesthetic.setOnClickListener(this);
        engineering.setOnClickListener(this);
        medicine.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent i;
        int id = v.getId();

        if(id == R.id.social){
            i = new Intent(this, AoiMain.class);
            i.putExtra("careerKey","social");
            startActivity(i);
        } else if(id == R.id.aesthetic){
            i = new Intent(this, AoiMain.class);
            i.putExtra("careerKey","aesthetic");
            startActivity(i);
        } else if(id == R.id.engineering){
            i = new Intent(this, AoiMain.class);
            i.putExtra("careerKey","engineering");
            startActivity(i);
        } else if(id == R.id.medicine){
            i = new Intent(this, AoiMain.class);
            i.putExtra("careerKey","medicine");
            startActivity(i);
        }

    }
}