package com.day5;

public class ReverseWords {
	public static String reverseWords(String s) {
        String[] words=s.trim().split("\\s+");
        StringBuilder result=new StringBuilder();
       for(int i=words.length-1;i>=0;i--) {
         result.append(words[i]);
        if(i!=0) 
           result.append(" ");
        }
        return result.toString();
    } 
  

    public static void main(String[] args) {
        String str = "  Hello   World  ";
        System.out.println("Original String ::"+str);
        System.out.println("Reversed words :: "+reverseWords(str));
    }
}
