package com.example.careerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String courseName = intent.getStringExtra("courseName");
        String courseField = intent.getStringExtra("courseField");
        String courseUrl = intent.getStringExtra("courseUrl");
        String courseDescription = intent.getStringExtra("courseDescription");

        TextView course_Name = findViewById(R.id.course_Name);
        TextView course_Description = findViewById(R.id.course_Description);
        TextView course_Field = findViewById(R.id.course_Field);
        TextView course_Url = findViewById(R.id.course_Url);

        course_Name.setText(courseName);
        course_Description.setText(courseDescription);
        course_Field.setText(courseField);

        course_Url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl(courseUrl);
            }
        });
    }

    private void gotoUrl(String website) {
        Uri uri = Uri.parse(website);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}