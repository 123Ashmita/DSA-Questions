package com.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class provides a method to solve the classic "Three Sum" problem.
 * Given an array of integers, the goal is to find all unique triplets in the array
 * that sum up to zero.
 * 
 * Example:
 * Input: nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 */
public class ThreeSum {

    /**
     * Finds all unique triplets in the array which gives the sum of zero.
     *
     * @param nums the input array of integers
     * @return a list of lists, where each inner list contains three integers that sum to zero
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // If input is null or has less than 3 elements, no triplet can be formed
        if (nums == null || nums.length < 3) return new ArrayList<>();

        // Sort the array to make two-pointer approach effective
        Arrays.sort(nums);

        // Use a set to store unique triplets
        Set<List<Integer>> result = new HashSet<>();

        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            // Two-pointer approach to find the remaining two numbers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Add the triplet to the result set (ordering matters for uniqueness)
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Move left pointer to increase the sum
                    left++;
                } else {
                    // Move right pointer to decrease the sum
                    right--;
                }
            }
        }

        // Convert set to list before returning
        return new ArrayList<>(result);
    }

    /**
     * The main method to test the threeSum method.
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        // Expected output: [[-1, -1, 2], [-1, 0, 1]]
        System.out.println("Three sum : " + threeSum(nums));
    }
}
