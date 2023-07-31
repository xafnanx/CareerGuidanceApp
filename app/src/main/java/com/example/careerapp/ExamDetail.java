package com.example.careerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ExamDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_detail);

        String exam_Name = getIntent().getExtras().getString("examName");
        String exam_Eligibility = getIntent().getExtras().getString("examEligibility");
        String exam_Date = getIntent().getExtras().getString("examDate");
        String exam_Description = getIntent().getExtras().getString("examDescription");
        String exam_Website = getIntent().getExtras().getString("examWebsite");
        //String exam_Logo = getIntent().getExtras().getString("examLogo");

        TextView examName = findViewById(R.id.examName);
        TextView examDescription = findViewById(R.id.examDescription);
        TextView examEligibility = findViewById(R.id.examEligibility);
        TextView examDate = findViewById(R.id.examDate);
        TextView examWebsite = findViewById(R.id.examWebsite);

        examName.setText(exam_Name);
        examDescription.setText(exam_Description);
        examEligibility.setText(exam_Eligibility);
        examDate.setText(exam_Date);

        examWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl(exam_Website);
            }
        });
    }

    private void gotoUrl(String website) {
        Uri uri = Uri.parse(website);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}