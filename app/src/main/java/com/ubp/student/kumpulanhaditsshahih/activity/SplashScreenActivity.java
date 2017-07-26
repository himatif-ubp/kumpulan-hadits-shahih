package com.ubp.student.kumpulanhaditsshahih.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ubp.student.kumpulanhaditsshahih.BulkData;
import com.ubp.student.kumpulanhaditsshahih.R;
import com.ubp.student.kumpulanhaditsshahih.util.MyPref;
import com.ubp.student.kumpulanhaditsshahih.util.Static;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if(!MyPref.getBoolean(getApplicationContext(), Static.LOADED)){
            BulkData bulkData = new BulkData();
            bulkData.imamData(getApplicationContext());
            bulkData.kitabData(getApplicationContext());
            bulkData.babData(getApplicationContext());
            bulkData.haditsData(getApplicationContext());
            bulkData.registerFirst(getApplicationContext());
            MyPref.putBoolean(getApplicationContext(), Static.LOADED, true);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {

                }catch (Exception e){

                }finally {
                    if(MyPref.getBoolean(getApplicationContext(), Static.LATEST_HADITS)){
                        startActivity(new Intent(getApplicationContext(), HaditsActivity.class));
                        finish();
                    }else {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                }
            }
        }, 2500);
    }

    @Override
    public void onBackPressed() {

    }
}
