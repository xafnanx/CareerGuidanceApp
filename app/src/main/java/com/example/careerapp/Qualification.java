package com.example.careerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.careerapp.activities.AoiMain;

public class Qualification extends AppCompatActivity implements View.OnClickListener {

    TextView tenth,twelveth,ugengineering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualification);

        // Initialization of layout elements
        tenth = findViewById(R.id.tenth);
        twelveth = findViewById(R.id.twelveth);
        ugengineering = findViewById(R.id.ugengineering);

        //Add a listener to Cards
        tenth.setOnClickListener(this);
        twelveth.setOnClickListener(this);
        ugengineering.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent i;
        int id = v.getId();

        if(id == R.id.tenth){
            i = new Intent(this, MainActivityJson.class);
            i.putExtra("courseKey","10th");
            startActivity(i);
        } else if(id == R.id.twelveth){
            i = new Intent(this, MainActivityJson.class);
            i.putExtra("courseKey","12th");
            startActivity(i);
        } else if(id == R.id.ugengineering){
            i = new Intent(this, MainActivityJson.class);
            i.putExtra("courseKey","ugEngineering");
            startActivity(i);
        }

    }
}