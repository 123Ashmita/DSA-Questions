package com.day4;

import java.util.*;

class Operations {
	public static int minOperations(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				return -1;
			}
			if (nums[i] > k) {
				set.add(nums[i]);
			}

		}
		return set.size();
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 5, 4, 5 };
		int k = 2;

		int result = minOperations(nums, k);
		System.out.println("Number of min operations " + result);
	}
}
