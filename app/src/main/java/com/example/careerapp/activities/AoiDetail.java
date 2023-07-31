package com.example.careerapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.careerapp.R;

public class AoiDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_aoi);

        Intent intent = getIntent();
        String careerName = intent.getStringExtra("careerName");
        String careerDescription = intent.getStringExtra("careerDescription");
        String careerUrl = intent.getStringExtra("careerUrl");
        String careerStream = intent.getStringExtra("careerStream");
        String careerSubject = intent.getStringExtra("careerSubject");
        String careerDifficulty = intent.getStringExtra("careerDifficulty");

        TextView career_Name_Detail = findViewById(R.id.career_Name_Detail);
        TextView career_Description_Detail = findViewById(R.id.career_Description_Detail);
        TextView career_Stream = findViewById(R.id.career_Stream);
        TextView career_Subject = findViewById(R.id.career_Subject);
        TextView career_Difficulty = findViewById(R.id.career_Difficulty);
        TextView career_Url = findViewById(R.id.career_Url);

        career_Name_Detail.setText(careerName);
        career_Description_Detail.setText(careerDescription);
        career_Stream.setText(careerStream);
        career_Subject.setText(careerSubject);
        career_Difficulty.setText(careerDifficulty);

        career_Url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl(careerUrl);
            }
        });
    }

    private void gotoUrl(String website) {
        Uri uri = Uri.parse(website);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}