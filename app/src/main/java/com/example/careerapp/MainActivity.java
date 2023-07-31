package com.example.careerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.careerapp.activities.AreaOfInterest;
import com.example.careerapp.activities.Collage;
import com.example.careerapp.activities.Exam;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView collageCard,examCard,careerCard,qualificationCard,feedbackCard,videosCard,tipsCard;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialization of layout elements

        collageCard = findViewById(R.id.collage);
        examCard = findViewById(R.id.exam);
        careerCard = findViewById(R.id.areaOfInterest);
        qualificationCard = findViewById(R.id.qualification);
        videosCard = findViewById(R.id.videos);
        tipsCard = findViewById(R.id.tips);
//        feedbackCard = findViewById(R.id.feedbackCard);

        btn = findViewById(R.id.logout);

        //Add a listener to Cards
        collageCard.setOnClickListener(this);
        examCard.setOnClickListener(this);
        careerCard.setOnClickListener(this);
        qualificationCard.setOnClickListener(this);
        videosCard.setOnClickListener(this);
        tipsCard.setOnClickListener(this);
//        feedbackCard.setOnClickListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i;
        int id = v.getId();

        if(id == R.id.collage){
            i = new Intent(this, Collage.class);
            startActivity(i);
        } else if(id == R.id.exam){
            i = new Intent(this, Exam.class);
            startActivity(i);
        } else if(id == R.id.areaOfInterest){
            //fix later
            i = new Intent(this, AreaOfInterest.class);
            startActivity(i);
        } else if(id == R.id.qualification){
            i = new Intent(this,Qualification.class);
            startActivity(i);
        } else if(id == R.id.videos){
            i = new Intent(this,CareerVideo.class);
            startActivity(i);
        } else if(id == R.id.tips){
            i = new Intent(this,CareerTips.class);
            startActivity(i);
        }

    }
}