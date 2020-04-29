package com.example.tradeday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class Login extends AppCompatActivity {
    EditText et;
    Button b;
    TextView textView, t11;
    long time;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et = findViewById(R.id.editText2);
        b = findViewById(R.id.button2);
        textView = findViewById(R.id.textView10);
        t11 = findViewById(R.id.textView11);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        if (pref.getLong("time", 0) == 0) {
            time = System.currentTimeMillis();
            editor.putLong("time", time); // Storing long
            editor.commit();
            textView.setText(String.valueOf(time));

        } else
            time = pref.getLong("time", 0);

        textView.setText(String.valueOf(time));

    }

    public void passwordChecker(View view) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();


        String s = passwordgenerator(String.valueOf(time));
        String k = String.valueOf(et.getText());
        if (s.equals(k)) {
            editor.putLong("lA", 1);
            editor.commit();
            Intent i = new Intent(Login.this, Dashboard.class);
            startActivity(i);
            finish();
        } else {
            t11.setText("Wrong Password");
        }
    }

    public String passwordgenerator(String s) {
        String res = "";
        long x = Long.parseLong(s.substring(8));
        res = String.valueOf(x * x);

        //System.out.println(res);
        if (Long.parseLong(res) < 100000000) {
            res = res + "7237987971";
            res = res.substring(5, res.length() - 3);
        }
        res = res.substring(5);
        return res;
    }

}
