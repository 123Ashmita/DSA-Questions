package com.day10;

public class LongestRepeatingCharacterReplacement {
	 public static int characterReplacement(String s, int k) {
	        int[] freq=new int[26];
	        int left=0;
	        int maxFrequency=0;
	        int maxWindow=0;
	        for(int right=0;right<s.length();right++) {
	            freq[s.charAt(right)-'A']++;
	            maxFrequency=Math.max(maxFrequency, freq[s.charAt(right)-'A']);
	            int windowLength=right-left+1;
	            if(windowLength-maxFrequency > k) {
	                freq[s.charAt(left)-'A']--;
	                left++;
	            } 
	            windowLength=right-left+1;
	            maxWindow=Math.max(maxWindow,windowLength);
	        }
	        return maxWindow;
	    }

	public static void main(String[] args) {
	  String s="AABABBA";
	  int k=1;
	  System.out.println(characterReplacement(s,k));
	}

}
