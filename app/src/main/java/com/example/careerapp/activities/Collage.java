package com.example.careerapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.careerapp.R;
import com.example.careerapp.adapters.ClgRecyclerViewAdapter;
import com.example.careerapp.model.collageModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Collage extends AppCompatActivity {
    private final String JSON_URL = "https://raw.githubusercontent.com/hencydsouza/jsonFiles/main/collage.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<collageModel> lstCollageModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collage);

        lstCollageModel = new ArrayList<>();

        recyclerView = findViewById(R.id.clg_recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest(){
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for(int i=0;i<response.length();i++){
                    try{
                        jsonObject = response.getJSONObject(i);
                        collageModel clg = new collageModel();
                        clg.setClgName(jsonObject.getString("clgName"));
                        clg.setClgLocation(jsonObject.getString("clgLocation"));
                        clg.setClg_Rating(jsonObject.getString("clgRating"));
                        clg.setClgWebsite(jsonObject.getString("clgWebsite"));
                        clg.setClgDescription(jsonObject.getString("clgDescription"));
                        clg.setClgPic(jsonObject.getString("clgPic"));
                        clg.setClgLogo(jsonObject.getString("clgLogo"));
                        lstCollageModel.add(clg);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                setrecyclerview(lstCollageModel);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(Collage.this);
        requestQueue.add(request);
    }

    private void setrecyclerview(List<collageModel> lstCollageModel) {

        ClgRecyclerViewAdapter clgAdapter = new ClgRecyclerViewAdapter(this, lstCollageModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(clgAdapter);
    }
}