package com.example.careerapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.careerapp.R;
import com.example.careerapp.adapters.ClgRecyclerViewAdapter;
import com.example.careerapp.adapters.ExamRecyclerViewAdapter;
import com.example.careerapp.model.collageModel;
import com.example.careerapp.model.examModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Exam extends AppCompatActivity {
    private final String JSON_URL = "https://raw.githubusercontent.com/hencydsouza/jsonFiles/main/exam.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<examModel> lstExamModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        lstExamModel = new ArrayList<>();

        recyclerView = findViewById(R.id.exam_recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for(int i=0;i<response.length();i++){
                    try{
                        jsonObject = response.getJSONObject(i);
                        examModel exam = new examModel();
                        exam.setExamName(jsonObject.getString("examName"));
                        exam.setExamEligibility(jsonObject.getString("examEligibility"));
                        exam.setExamDate(jsonObject.getString("examDate"));
                        exam.setExamWebsite(jsonObject.getString("examWebsite"));
                        exam.setExamLogo(jsonObject.getString("examLogo"));
                        exam.setExamDescription(jsonObject.getString("examDescription"));
                        lstExamModel.add(exam);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                setrecyclerview(lstExamModel);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(Exam.this);
        requestQueue.add(request);
    }

    private void setrecyclerview(List<examModel> lstExamModel) {
        ExamRecyclerViewAdapter examAdapter = new ExamRecyclerViewAdapter(this, lstExamModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(examAdapter);
    }
}