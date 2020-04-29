package com.example.tradeday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void vwap(View view) {
        Intent i = new Intent(Dashboard.this, MainActivity.class);
        startActivity(i);
    }

    public void fibo(View view) {
        Intent i = new Intent(Dashboard.this, Main2Activity.class);
        startActivity(i);
    }
}
