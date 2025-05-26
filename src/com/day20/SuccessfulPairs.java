package com.day20;

import java.util.Arrays;

/**
 * This class provides a method to count how many potions can successfully pair with each spell.
 * A pair is considered successful if spell[i] * potion[j] >= success.
 *
 * Problem Source: Leetcode 2300 - Successful Pairs of Spells and Potions
 */
public class SuccessfulPairs {

    /**
     * Calculates how many potions can form a successful pair with each spell.
     *
     * @param spells  Array of spell strengths
     * @param potions Array of potion strengths
     * @param success Minimum product required for a successful pair
     * @return An array where each element represents the count of successful pairs for the corresponding spell
     */
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);  // Sort the potions to allow binary search
        int[] result = new int[spells.length];  // To store the result for each spell

        // For each spell, calculate the number of successful potions
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];

            // Calculate the minimum required potion strength to be successful
            long minPotion = (long) Math.ceil((double) success / spell);

            // Find the first potion that satisfies the condition using binary search
            int index = firstGreaterOrEqual(potions, minPotion);

            // All potions from this index to the end are successful
            result[i] = potions.length - index;
        }

        return result;
    }

    /**
     * Binary search to find the first index in potions[] where potion >= target.
     *
     * @param potions Sorted array of potion strengths
     * @param target  The minimum required potion strength
     * @return Index of the first potion >= target
     */
    private static int firstGreaterOrEqual(int[] potions, long target) {
        int left = 0;
        int right = potions.length - 1;

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (potions[mid] < target) {
                left = mid + 1;  // Look in the right half
            } else {
                right = mid - 1; // Look in the left half
            }
        }

        // 'left' now points to the first element >= target
        return left;
    }

    /**
     * Main method to test the successfulPairs method.
     */
    public static void main(String[] args) {
        int[] spells = {5, 1, 3};             // Sample input spells
        int[] potions = {1, 2, 3, 4, 5};      // Sample input potions
        int success = 7;                      // Success threshold

        // Call the method and store the result
        int[] result = successfulPairs(spells, potions, success);

        // Print the result array
        System.out.println(Arrays.toString(result)); // Output should be: [4, 0, 3]
    }
}
