package com.example.careerapp.activities;

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
import com.example.careerapp.R;
import com.example.careerapp.adapters.AoiRecycleViewAdapter;
import com.example.careerapp.model.aoiModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AoiMain extends AppCompatActivity implements AoiRecycleViewAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private AoiRecycleViewAdapter mAoiRecycleViewAdapter;
    private ArrayList<aoiModel> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aoi);

        String careerKey = getIntent().getExtras().getString("careerKey");

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON(careerKey);
    }

    private void parseJSON(String key) {
        String url = "https://raw.githubusercontent.com/hencydsouza/jsonFiles/main/career.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray(key);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String careerName = hit.getString("careerName");
                                String careerDescription = hit.getString("careerDescription");
                                String careerUrl = hit.getString("careerUrl");
                                String careerStream = hit.getString("careerStream");
                                String careerSubject = hit.getString("careerSubject");
                                String careerDifficulty = hit.getString("careerDifficulty");

                                mExampleList.add(new aoiModel(careerName, careerDescription, careerUrl,careerStream,careerSubject,careerDifficulty));
                            }

                            mAoiRecycleViewAdapter = new AoiRecycleViewAdapter(AoiMain.this, mExampleList);
                            mRecyclerView.setAdapter(mAoiRecycleViewAdapter);
                            mAoiRecycleViewAdapter.setOnItemClickListener(AoiMain.this);

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
        Intent detailIntent = new Intent(this, AoiDetail.class);
        aoiModel clickedItem = mExampleList.get(position);

        detailIntent.putExtra("careerName", clickedItem.getCareerName());
        detailIntent.putExtra("careerDescription", clickedItem.getCareerDescription());
        detailIntent.putExtra("careerUrl", clickedItem.getCareerUrl());
        detailIntent.putExtra("careerStream", clickedItem.getCareerStream());
        detailIntent.putExtra("careerSubject", clickedItem.getCareerSubject());
        detailIntent.putExtra("careerDifficulty", clickedItem.getCareerDifficulty());

        startActivity(detailIntent);
    }
}