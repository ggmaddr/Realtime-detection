package edu.sjsu.android.project1gradyta;
import java.lang.Math;

public class Calculator {
    public static double calculate(double P, double J, int N, double T){
        double m;
        if (J == 0) {
            m = P/N + T;
        }
        else{
            m = (P*J)/(1-Math.pow(1+J, -N)) + T;
        }
        return m;
    }

}
