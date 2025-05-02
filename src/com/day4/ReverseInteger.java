package com.day4;

public class ReverseInteger {
	 public static int reverse(int x) {
         if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
              return 0 ;
             }
        int rev=0;
        while(x!=0) {
            int rem=x%10;
            if(rev> Integer.MAX_VALUE/10 || rev< Integer.MIN_VALUE/10) {
                return 0;
            }
            rev=rev*10+rem;
//            System.out.println(rev);
             x=x/10;
        }
            return rev;
        
    }

	public static void main(String[] args) {

		int x = -1463847412;
		System.out.println("Original number :: " + x);
		System.out.println("Reveresed number :: " + reverse(x));

	}

}
