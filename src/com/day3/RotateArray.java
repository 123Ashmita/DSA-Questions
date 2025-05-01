package com.day3;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k=k % n;

		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;

		}
	}

	public static void main(String[] args) {
		int[] nums = {-1,-100,3,99};
		System.out.println("Original Array :");
		for(int i=0;i<nums.length;i++) {
	    	System.out.print(nums[i]+" ");
	    }
		System.out.println();
		System.out.println("Rotated Array :");
	    rotate(nums,5);
	    for(int i=0;i<nums.length;i++) {
	    	System.out.print(nums[i]+" ");
	    }

	}
}
