package edu.sjsu.android.project1gradyta;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorUnitTest {
    private double getActual(double P, double J, int N, boolean withTax){
        double T = withTax ? P * 0.1 / 100 : 0.0;
        return Calculator.calculate(P, J/1200.0, N*12, T);
    }
    @Test
    public void no_interest_no_tax(){
        double actual = getActual(20000,0.0,20,false);
        assertEquals(83.33, actual,0.01);
    }
    @Test
    public void no_tax(){
        double actual = getActual(10000.00,5.5,15,false);
        assertEquals(81.71, actual,0.01);
    }

    @Test
    public void with_interest_with_tax(){
        double actual = getActual(10000.0, 5.5, 15, true );
        assertEquals(91.71, actual, 0.01);
    }
}