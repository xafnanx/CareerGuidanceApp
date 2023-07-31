package com.example.careerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityJson extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_json2);

        String courseKey = getIntent().getExtras().getString("courseKey");

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON(courseKey);
    }

    private void parseJSON(String key) {
        String url = "https://raw.githubusercontent.com/hencydsouza/jsonFiles/main/qualification.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray(key);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String courseName = hit.getString("courseName");
                                String courseField = hit.getString("courseField");
                                String courseUrl = hit.getString("courseUrl");
                                String courseDescription = hit.getString("courseDescription");

                                mExampleList.add(new ExampleItem(courseName, courseField, courseUrl,courseDescription));
                            }

                            mExampleAdapter = new ExampleAdapter(MainActivityJson.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnItemClickListener(MainActivityJson.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ExampleItem clickedItem = mExampleList.get(position);

        detailIntent.putExtra("courseName", clickedItem.getCourseName());
        detailIntent.putExtra("courseField", clickedItem.getCourseField());
        detailIntent.putExtra("courseUrl", clickedItem.getCourseUrl());
        detailIntent.putExtra("courseDescription",clickedItem.getCourseDescription());

        startActivity(detailIntent);
    }
}