package com.example.tradeday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;
import java.util.Hashtable;
import java.util.Enumeration;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Main2Activity extends AppCompatActivity {
    private static DecimalFormat df2 = new DecimalFormat("#.###");
    TextView t14, t15, t16;
    EditText et, et1, et2;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t14 = findViewById(R.id.textView14);
        t15 = findViewById(R.id.textView52);
        t16 = findViewById(R.id.textView53);
        et = findViewById(R.id.editText4);
        et1 = findViewById(R.id.editText5);
        et2 = findViewById(R.id.editText6);
        constraintLayout = findViewById(R.id.constraintLayout);
    }


    public void operation2(View view) {
        Logic logic = new Logic();
        //constraintLayout.setBackgroundColor(Color.rgb(255,255,255));
        double[] w = logic.calculate(Double.valueOf(String.valueOf(et2.getText())));
        double[] v = logic.stockAstro(w[0], w[1], w[2]);


        double x = Double.parseDouble(String.valueOf(et.getText())) -
                Double.parseDouble(String.valueOf(et1.getText())),
                y = Double.parseDouble(String.valueOf(et1.getText()));
        Logic2 l = new Logic2();
        double[] stage = l.fibo(x, y);

        for (double var : stage) {
            System.out.println(var);
        }
        TreeMap<Double, String> tm = new TreeMap<Double, String>();
        for (int j = 0; j < stage.length; j++) {
            for (int k = 0; k < v.length; k++) {
                double temp;
                if (k != 3)

                    if (v[k] - stage[j] < 0) {
                        tm.put(stage[j] - v[k], v[k] + "-" + stage[j]);
                    } else
                        tm.put(v[k] - stage[j], v[k] + "-" + stage[j]);
            }
        }
        System.out.println(tm);
        // Get a set of the entries
        Set set = tm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        int count = 0;
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
            double input = Double.parseDouble(String.valueOf(me.getKey()));
            String xxx = String.valueOf(me.getValue());

            t14.setText(t14.getText() + df2.format(Double.parseDouble(xxx.substring(0, xxx.indexOf('-')))) + "\n\n");
            t15.setText(t15.getText() + df2.format(Double.parseDouble(xxx.substring(xxx.indexOf('-') + 1))) + "\n\n");
            t16.setText(t16.getText() + df2.format(input) + "\n\n");
            count++;
            if (count > 9)
                break;
        }


    }
}
