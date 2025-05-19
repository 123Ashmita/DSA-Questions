package com.day15;

/**
 * This class provides a method to find the length of the longest subarray
 * that contains only 1s after deleting at most one 0 from the array.
 * Example:
 * For the input array nums = {0, 1, 1, 1, 0, 1, 1, 0, 1}, 
 * the method will return 5, which is the length of the longest 
 * contiguous subarray with only 1s after removing one 0.
 */
public class LongestSubarray {

    /**
     * Returns the length of the longest subarray consisting only of 1s
     * after deleting at most one 0.
     *
     * @param nums The input binary array containing 0s and 1s.
     * @return The length of the longest valid subarray.
     */
    public static int longestSubarray(int[] nums) {
        int ans = 0;      // Stores the maximum length of the subarray
        int left = 0;     // Left pointer of the sliding window
        int count = 0;    // Counts the number of 0s in the current window

        // Traverse the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;  // Increment count if we find a 0
            }

            // If the window has more than one 0, move the left pointer
            while (count > 1) {
                if (nums[left] == 0) {
                    count--;  // Decrease count when a 0 is removed
                }
                left++;  // Shrink the window from the left
            }

            // Update the maximum length found (right - left)
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    /**
     * The main method to test the longestSubarray method.
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println("Longest Subarray : " + longestSubarray(nums));
    }
}
