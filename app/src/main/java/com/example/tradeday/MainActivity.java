package com.example.tradeday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView, et1, et2, et3, et4, et5, et6, et7, et8;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView2);
        edittext = findViewById(R.id.editText);
        et1 = findViewById(R.id.textView4);
        et2 = findViewById(R.id.textView5);
        et3 = findViewById(R.id.textView6);
        et4 = findViewById(R.id.textView7);
        et5 = findViewById(R.id.textView8);
        et6 = findViewById(R.id.textView9);
        et7 = findViewById(R.id.textView17);
        et8 = findViewById(R.id.textView18);


    }

    public void operation(View view) {
        Logic logic = new Logic();
        String chawani = String.valueOf(edittext.getText());
        String res = "";
        double x = Double.valueOf(chawani);
        double[] w = logic.calculate(x);
        double[] v = logic.stockAstro(w[0], w[1], w[2]);
        for (double var : v) {
            res = res + var + "\n";
        }
        et7.setText("Target  (-4):      " + v[0]);
        textView.setText("Target  (-3):      " + v[1]);
        et1.setText("Target  (-2):      " + v[2]);
        et2.setText("Target  (-1):      " + v[3]);
        et3.setText("VWAP price :      " + v[4]);
        et4.setText("Target  (+1):      " + v[5]);
        et5.setText("Target  (+2):      " + v[6]);
        et6.setText("Target  (+3):      " + v[7]);
        et8.setText("Target  (+4):      " + v[8]);


    }
}
