package com.day1;

import java.util.HashSet;
import java.util.Set;

public class SubString {
	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println("Length of longest substring without repeating characters: "+uniqueElement(s));		
					
   }
	public static int uniqueElement(String s) {
		 Set<Character> uniqueString=new HashSet<>();
	       int start=0;
	       int end;
	       int maxLen=0;
	      
	        for(end=0;end<s.length();end++) {
	            while(uniqueString.contains(s.charAt(end))) {
	                uniqueString.remove(s.charAt(start));
	                start++;
	            }
	            uniqueString.add(s.charAt(end));
	            maxLen=Math.max(maxLen,end-start+1);
	        }
				return maxLen;
		    }
}
