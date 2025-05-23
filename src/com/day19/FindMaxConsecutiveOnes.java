package com.day19;

/**
 * This class contains a method to find the maximum number of 
 * consecutive 1's in a binary array.
 */
public class FindMaxConsecutiveOnes {

    /**
     * Finds the maximum number of consecutive 1's in the given integer array.
     *
     * @param nums the input array consisting of 0s and 1s
     * @return the maximum number of consecutive 1s
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;      // To store the maximum count of consecutive 1s
        int currentCount = 0;  // To count the current streak of 1s

        // Loop through each number in the array
        for (int num : nums) {
            if (num == 1) {
                currentCount++; // Increment current count if the number is 1
                maxCount = Math.max(maxCount, currentCount); // Update maxCount
            } else {
                currentCount = 0; // Reset count if the number is 0
            }
        }

        return maxCount;
    }

    // main method to test function
    public static void main(String[] args) {
        // Sample input array
        int[] nums = {1, 1, 0, 1, 1, 1};

        // Print the result
        System.out.println("The maximum number of consecutive 1's in the array: "
                + findMaxConsecutiveOnes(nums));
    }
}
