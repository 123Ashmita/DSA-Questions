package com.day11;

/**
 * This class contains a method to find the minimum length of a contiguous subarray 
 * of which the sum is greater than or equal to the given target value.
 */
public class MinSubArrayLen {

    /**
     * Returns the minimal length of a contiguous subarray of which the sum is 
     * greater than or equal to the target value. If there is no such subarray, returns 0.
     *
     * @param target the target sum to be achieved
     * @param nums the array of positive integers
     * @return the length of the smallest subarray with sum >= target
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int minLenWindow = Integer.MAX_VALUE; // Initialize with max value to track the minimum window length
        int currSum = 0; // Current window sum
        int low = 0; // Start index of the window
        int high = 0; // End index of the window (exclusive)

        // Iterate through the array using sliding window technique
        while (high < nums.length) {
            currSum += nums[high]; // Expand the window by adding the current element
            high++;

            // Shrink the window from the left as long as the current sum is >= target
            while (currSum >= target) {
                int currWindowSize = high - low;
                minLenWindow = Math.min(minLenWindow, currWindowSize); // Update minimum length if smaller window is found
                currSum -= nums[low]; // Shrink the window from the left
                low++;
            }
        }

        // Return 0 if no valid subarray was found
        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }

    /**
     * Main method to test the minSubArrayLen function with an example input.
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3}; // Example array
        int target = 7; // Target sum
        System.out.println("Minimum Sub Array Length: " + minSubArrayLen(target, nums));
    }
}
