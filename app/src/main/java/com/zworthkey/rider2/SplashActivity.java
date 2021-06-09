package com.zworthkey.rider2;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.zworthkey.rider2.ui.login.LoginActivity;


public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT=900;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
               /* Intent i=new Intent(SplashActivity.this,
                        LoginActivity.class);*/
                 Intent i=new Intent(SplashActivity.this,
                        MainActivity.class);
                /*Todo MainActivity will be replaced by loginActivity here in production stage*/
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.*/

                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);


    }
}