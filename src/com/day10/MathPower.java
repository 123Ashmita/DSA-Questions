package com.day10;

public class MathPower {
	 public double myPow(double x, int n) {
	       Long N=(long) n;
	        if (N < 0) {
	            x = 1 / x;
	            N = -N;
	        }
	       double result = 1;
	        while (N > 0) {
	            if (N % 2 == 1) {
	                result = result*x;
	            }
	             x=x*x;
	             N = N/2;
	        }
	        return result;
	    }
	public static void main(String[] args) {
		MathPower mp=new MathPower();
         double x=2.00000;
         int n=-2;
         System.out.println(mp.myPow(x,n));   // 0.25000 
	}

}
