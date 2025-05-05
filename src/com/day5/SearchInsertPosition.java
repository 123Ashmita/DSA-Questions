package com.day5;

public class SearchInsertPosition {
	
	public static int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start <= end) {
            int mid=(start+end)/2;

            if(target>nums[mid]) {
                start=mid+1;
            }
            if(target<nums[mid]) {
                end=mid-1;
            }
            if(target==nums[mid]) {
                return mid;
            }
        }
        return end+1;
    }  
	
	public static void main(String[] args) {
       int[] nums= {1,3,5,6};
       int target=7;
      System.out.println(searchInsert(nums,target));       
	}
}
