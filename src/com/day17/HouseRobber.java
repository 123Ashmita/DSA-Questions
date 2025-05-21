package com.day17;

/**
 * This class provides a method to solve the House Robber problem using dynamic programming.
 * The problem is to find the maximum amount of money a robber can rob without robbing 
 * two adjacent houses.
 */
public class HouseRobber {

    /**
     * Calculates the maximum amount of money that can be robbed from a line of houses,
     * where adjacent houses cannot be robbed on the same night.
     *
     * @param nums an array representing the amount of money in each house
     * @return the maximum amount of money that can be robbed
     */
    public int rob(int[] nums) {

        // prev2 stores the result for house i-2
        int prev2 = 0;

        // prev1 stores the result for house i-1
        int prev1 = 0;

        // Iterate through each house
        for (int i = 0; i < nums.length; i++) {
            // Temporarily store prev1 (dp[i-1])
            int temp = prev1;

            // Update prev1 to the max of (skip current house) or (rob current + dp[i-2])
            prev1 = Math.max(prev1, prev2 + nums[i]);

            // Move prev2 to the old prev1
            prev2 = temp;
        }

        // prev1 contains the result for the last house
        return prev1;
    }

    /**
     * Main method to test the rob method.
     */
    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();

        int[] nums = {1, 2, 3, 1};  // Test input
        System.out.println("Maximum money that can be robbed: " + robber.rob(nums));  // Expected Output: 4
    }
}
