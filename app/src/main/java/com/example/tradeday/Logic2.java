package com.example.tradeday;

public class Logic2 {
    //double []tab ={-78.6,-61.8,-50,-38.2,-23.6,0,23.6,38.2,50,61.8,78.6,100,138.2,161.8,261.8,423.6};
    double[] tab = {-61.8, -38.2, 0, 38.2, 50, 61.8, 100, 138.2, 161.8};

    protected double[] fibo(double diff, double low) {
        double[] res = new double[tab.length];
        for (int x = 0; x < tab.length; x++) {
            res[x] = perc(low, diff, tab[x]);
            //System.out.println(res[x]);
        }
        return res;
    }

    protected double perc(double low0, double low, double per) {
        return low0 + (low * per) / 100;
    }
}