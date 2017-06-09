package com.ubp.student.kumpulanhadis.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ubp.student.kumpulanhadis.BulkData;
import com.ubp.student.kumpulanhadis.R;
import com.ubp.student.kumpulanhadis.util.MyPref;
import com.ubp.student.kumpulanhadis.util.Static;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    if(!MyPref.getBoolean(getApplicationContext(), Static.LOADED)){
                        new BulkData().start();
                        MyPref.putBoolean(getApplicationContext(), Static.LOADED, true);
                    }
                }catch (Exception e){

                }finally {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        }, 2500);
    }

    @Override
    public void onBackPressed() {

    }
}
