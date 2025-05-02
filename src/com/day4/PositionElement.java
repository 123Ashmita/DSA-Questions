package com.day4;

public class PositionElement {
	 static int[] result=new int[2];
	 public static int[] searchRange(int[] nums, int target) {
	        int n=nums.length;
	        result[0]=-1;
	        result[1]=-1;
	       for(int i=0;i<n;i++) {
	        if(nums[i]==target) {
	            result[0]=i;
	            break;
	        }
	       }
	        for(int i=n-1;i>=0;i--) {
	        if(nums[i]==target) {
	            result[1]=i;
	            break;
	        }
	        } 
	        return result;

	    } 

	public static void main(String[] args) {
		int[] nums= {5,7,7,8,8,10};
		int target = 8;
		System.out.println("Original Array");
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
		searchRange(nums,target);
		System.out.println();
		System.out.println("target 8 index from start to end: ");
		int n=result.length;
		for(int i=0;i<n;i++) {
			System.out.print(result[i]+" ");
		}

	}

}
