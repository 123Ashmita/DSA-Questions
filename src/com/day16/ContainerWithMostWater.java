package com.day16;

/**
 * This class provides a method to find the maximum area that can be formed
 * by two lines from an array of heights, using the two-pointer technique.
 */
public class ContainerWithMostWater {

    /**
     * This method calculates the maximum area of water that can be trapped
     * between two lines in the given array of heights.
     *
     * @param height an array where each element represents the height of a line
     * @return the maximum area formed between two lines
     */
    public static int maxArea(int[] height) {
        // Initialize two pointers: one at the beginning (left) and one at the end (right)
        int left = 0;
        int right = height.length - 1;
        
        // Variable to store the maximum area
        int maxArea = 0;

        // Loop until the two pointers meet
        while (left < right) {
            // Calculate the area formed by the lines at the left and right pointers
            int area = Math.min(height[left], height[right]) * (right - left);
            
            // Update the max area if the current area is greater
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line to potentially find a larger area
            if (height[left] < height[right]) 
                left++;
            else 
                right--;
        }

        // Return the maximum area found
        return maxArea;
    }

    public static void main(String[] args) {
        // Test case: array of heights
        int[] height = {1,8,6,2,5,4,8,3,7};
        
        // Print the result of finding the maximum area
        System.out.println("Max Area: " + maxArea(height));
    }
}
