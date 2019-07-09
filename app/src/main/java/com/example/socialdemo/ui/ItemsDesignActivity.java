package com.example.socialdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.example.socialdemo.R;
import com.example.socialdemo.adapter.JobItemsAdapter;
import com.example.socialdemo.data.model.MedicalPojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemsDesignActivity extends AppCompatActivity {

    private List<MedicalPojo> medicalPojos;
    private RecyclerView recyclerView ;
    private JobItemsAdapter jobItemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_design);
        medicalPojos=new ArrayList<>();
        medicalPojos.add( new MedicalPojo("brain", ""));
        medicalPojos.add( new MedicalPojo("brain2", ""));
        medicalPojos.add( new MedicalPojo("brain 3", ""));
        medicalPojos.add( new MedicalPojo("brain 4", ""));
        medicalPojos.add( new MedicalPojo("brain 5", ""));
        medicalPojos.add( new MedicalPojo("brain 6", ""));

        recyclerView = findViewById(R.id.jobRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        jobItemsAdapter = new JobItemsAdapter(medicalPojos, this);
        recyclerView.setAdapter(jobItemsAdapter);
    }

    public void getLanguage(View view) {
        String languagetype="en";
//        if (languagetype.isEmpty()){
        languagetype= Locale.getDefault().getLanguage();//"en";//sharedPreferences_show.getString("languagetype","ar");

        if (languagetype.equals("en")){
            languagetype="ar";
        }else {
            languagetype="en";
        }

        Locale locale = new Locale(languagetype);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config,getApplicationContext().getResources().getDisplayMetrics());
        Intent refresh = new Intent(this, ItemsDesignActivity.class);
        startActivity(refresh);
        finish();
    }
}