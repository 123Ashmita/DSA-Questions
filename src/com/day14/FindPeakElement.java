package com.day14;

/*
 * This class is used to find the Peak element in an array.
 * For example, given the array nums = {1,2,1,3,5,6,4} ,
 * the method will return the peak element index , which is 5.
 */
public class FindPeakElement {
	/*
     * This method finds the peak element in the given array.
     * It uses concept of Binary Search algorithm
     * 
     * @param nums - the array of integers
     * @return - the peak element index
     */
	public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        //loop till ( start less then end)
        while (start < end) {
        	
        	//finding mid 
            int mid = (start+end) / 2;

            //if nums[mid] < nums[mid+1] then update start=mid+1
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } 
            //if nums[mid] > nums[mid+1] then update end=mid
            else {
                end = mid; 
            }
        }
        //return peek element index
        return start; 
    }
	// Main method to test the peak element index method
	public static void main(String[] args) {
		int[] nums= {1,2,1,3,5,6,4};  //input array
		System.out.println("The 	 peek element index : "+findPeakElement(nums)); //output should 5 
	}

}
