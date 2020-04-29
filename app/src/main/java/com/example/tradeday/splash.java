package com.example.tradeday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import java.util.concurrent.TimeUnit;

public class splash extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT = 1500;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private int expiry = 30;
    // TimeUnit.DAYS.toMillis(1);     // 1 day to milliseconds.
//TimeUnit.MINUTES.toMillis(23); // 23 minutes to milliseconds.
//TimeUnit.HOURS.toMillis(4);    // 4 hours to milliseconds.
//TimeUnit.SECONDS.toMillis(96); // 96 seconds to milliseconds.
    long expiry_data = TimeUnit.DAYS.toMillis(expiry);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.

        super.onCreate(savedInstanceState);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        long it = pref.getLong("time", 0);
        long ct = System.currentTimeMillis();
        boolean y1 = true;
        if ((ct - it) > expiry_data) {
            y1 = false;
        }
        final boolean y = y1;
        final boolean x = pref.getLong("lA", 0) == 0;
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;

                if (x) {
                    i = new Intent(splash.this, Login.class);
                } else {
                    if (y)
                        i = new Intent(splash.this, Dashboard.class);
                    else {
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putLong("time", System.currentTimeMillis()); // Storing long
                        editor.commit();
                        i = new Intent(splash.this, Login.class);
                    }

                }
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }
}
