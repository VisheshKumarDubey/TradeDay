package com.example.tradeday;

import java.lang.*;

public class Logic {

    double[] value1 = {0.0, 0.125, 0.25, 0.375, 0.5, 0.625, 0.75, 0.875, 1};
    double[][] mapping = {
            {4, 5, 6, 7, 0, 1, 2, 3, 4},//-4
            {5, 6, 7, 0, 1, 2, 3, 4, 5},//-3
            {6, 7, 0, 1, 2, 3, 4, 5, 6},//-2
            {7, 0, 1, 2, 3, 4, 5, 6, 7},//-1
            {0, 1, 2, 3, 4, 5, 6, 7, 8},//0
            {1, 2, 3, 4, 5, 6, 7, 8, 1},//+1
            {2, 3, 4, 5, 6, 7, 8, 1, 2},//+2
            {3, 4, 5, 6, 7, 8, 1, 2, 3},//+3
            {4, 5, 6, 7, 8, 1, 2, 3, 4}//+4
    };

    protected double[] calculate(double input) {
        double x = input, y = 0.0, a, a1, a2, res, resInd, rexInd;
        for (int i = 0; i < 50000; i++) {
            if (i % 2 != 0) {

                if (y < x) {
                    y = y + i;
                } else {
                    break;
                }
            }
        }
        a = Math.sqrt(y);
        a1 = a - 2;
        res = 10000;
        resInd = -1;
        rexInd = -1;
        a2 = a + 2;
        if (a + 1 >= 470 || a + 2 >= 470)
            a2 = a;
        for (double k = a1; k < a2; k++) {
            for (int j = 0; j < 9; j++) {
                double temp;
                if (Math.pow((k + value1[j]), 2) - x < 0)
                    temp = x - Math.pow((k + value1[j]), 2);
                else
                    temp = (Math.pow((k + value1[j]), 2) - x);
                if (temp < res) {
                    res = temp;
                    resInd = k;
                    rexInd = j;
                }

            }
        }


        double[] baby = {res, resInd, rexInd};
        //final result printing
        return baby;
    }

    protected double[] stockAstro(double z, double y, double x) {
        System.out.println(z + " " + x + " " + y);
        double[] baby = new double[9];
        int c = (int) x;

        if (c == 8) {
            y++;
            c = 0;
        }

        if (y != 0 && c <= 4) {
            y--;
        }
        for (int r = 0; r < 9; r++) {
            if (y == 0 && c == 0 && r < 4) {
                baby[r] = 0;
            } else {
                baby[r] = Math.pow((y) + value1[(int) mapping[r][c]], 2);
            }
            if (y != 0 && c < 4) {
               // baby[r] = Math.pow((y) + value1[(int) mapping[r][c]], 2);
                if (mapping[r][c] == 0) {
                    y++;
                    baby[r] = Math.pow((y) + value1[(int) mapping[r][c]], 2);

                }
                else
                    baby[r] = Math.pow((y) + value1[(int) mapping[r][c]], 2);

            }
            else if( y!=0 && c==4)
            {
               if(r==0)
               {
                   y++;
                   baby[r] = Math.pow((y) + value1[(int) mapping[r][c]], 2);
               }
               else
                   baby[r] = Math.pow((y) + value1[(int) mapping[r][c]], 2);
            }
            else if (y != 0 && c > 4) {

                if (mapping[r][c] == 8){


                    baby[r] = Math.pow((y) + value1[(int) mapping[r][c]], 2);
                    y++;
                }
                else
                    baby[r] = Math.pow((y) + value1[(int) mapping[r][c]], 2);


            }
        }
        return baby;
    }


}

