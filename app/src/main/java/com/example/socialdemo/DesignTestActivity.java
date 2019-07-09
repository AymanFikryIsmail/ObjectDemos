package com.example.socialdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socialdemo.adapter.DepartmentAdapter;
import com.example.socialdemo.adapter.MdeicalAdapter;
import com.example.socialdemo.data.model.MedicalPojo;
import com.example.socialdemo.utility.Fonts;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DesignTestActivity extends AppCompatActivity {//implements NotificationReceiver.NotificationReceiverListener{

    private List<MedicalPojo> medicalPojos;
    private RecyclerView recyclerView , gridRecycleView;
    private MdeicalAdapter mdeicalAdapter;
    private DepartmentAdapter departmentAdapter;
    private SliderLayout sliderLayout;
    TextView medDep , departs;
    Button productBtn;
    Fonts fonts;
    IntentFilter mIntentFilter;
    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(receiver, mIntentFilter);
    }
    private BroadcastReceiver receiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isForground= false;
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
            if (appProcesses == null) {
                isForground= false;
            }
            final String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                    isForground= true;
                }
            }
            if (isForground){
                Toast.makeText(context,"Please Check Your data",Toast.LENGTH_SHORT).show();
            }

        }
    };
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_test);
             mIntentFilter = new IntentFilter();
            mIntentFilter.addAction("com.objects.NotificationReceiver11");

//            receiver.addListener(this);
//            this.registerReceiver(receiver, new IntentFilter());

            fonts= Fonts.getInstance(this);
        medicalPojos=new ArrayList<>();
        medicalPojos.add( new MedicalPojo("brain", ""));
        medicalPojos.add( new MedicalPojo("brain2", ""));
        medicalPojos.add( new MedicalPojo("brain 3", ""));
        medicalPojos.add( new MedicalPojo("brain 4", ""));
        medicalPojos.add( new MedicalPojo("brain 5", ""));
        medicalPojos.add( new MedicalPojo("brain 6", ""));

        initSlider();
        initView();

        productBtn=findViewById(R.id.productBtn);
        productBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLanguage();

            }
        });
    }


    void initView(){
        recyclerView = findViewById(R.id.medicalRV);
        gridRecycleView = findViewById(R.id.gridRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setReverseLayout(false);

        recyclerView.setLayoutManager(linearLayoutManager);
        mdeicalAdapter = new MdeicalAdapter(medicalPojos, this);
        recyclerView.setAdapter(mdeicalAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 2);
        gridRecycleView.setLayoutManager(gridLayoutManager);
        departmentAdapter = new DepartmentAdapter(medicalPojos, this);
        gridRecycleView.setAdapter(departmentAdapter);
         medDep =findViewById(R.id.medDepId);
        departs =findViewById(R.id.DepId);

        medDep.setTypeface(fonts.getCustomFont());
    }
    void initSlider(){
        sliderLayout = findViewById(R.id.imageSlider);
//        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :
        setSliderViews();
    }
    private void setSliderViews() {
        String  pathes[]={"http://images.cartradeexchange.com//img//800//vehicle//Honda_Brio_562672_5995_6_1438153637072.jpg" ,
         "https://wetravelapp.herokuapp.com/1560875953825.3145download.jpg",
                "https://wetravelapp.herokuapp.com/1560876833784.6978images.jpg"};
        for (int i = 0; i < 3; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(this);
            sliderView.setImageUrl(pathes[i]);
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
            sliderLayout.addSliderView(sliderView);
        }
    }

    void getLanguage(){
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
        Intent refresh = new Intent(DesignTestActivity.this, DesignTestActivity.class);
        startActivity(refresh);
        finish();

        //        Resources res = getResources();
//// Change locale settings in the app.
//        DisplayMetrics dm = res.getDisplayMetrics();
//        android.content.res.Configuration conf = res.getConfiguration();
//        conf.setLocale(new Locale(language_code.toLowerCase())); // API 17+ only.
//// Use conf.locale = new Locale(...) if targeting lower versions
//        res.updateConfiguration(conf, dm);
    }

//    @Override
//    public void updateUI() {
//        Toast.makeText(this,"from the activity",Toast.LENGTH_SHORT).show();
//
//    }

    public void onDestroy() {
        super.onDestroy();
//        receiver.removeListener(this);
        this.unregisterReceiver(receiver);
    }
}
