package com.day19;

/**
 * This class provides a method to determine if a given number of new flowers
 * can be planted in a flowerbed without violating the no-adjacent-flowers rule.
 */
public class CanPlaceFlowers {

    /**
     * Determines if 'n' new flowers can be planted in the flowerbed without violating
     * the rule that no two flowers can be adjacent.
     *
     * @param flowerbed the input array representing the flowerbed (0 = empty, 1 = planted)
     * @param n the number of flowers to plant
     * @return true if it's possible to plant n flowers, false otherwise
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true; // No need to plant, so return true

        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current spot is empty and adjacent spots are also empty or out of bounds
            if (flowerbed[i] == 0 && 
                (i == 0 || flowerbed[i - 1] == 0) && 
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1; // Plant a flower
                count++; // Increase the count of planted flowers

                if (count == n) {
                    return true; // Required number of flowers planted
                }
            }
        }

        return false; // Not enough space to plant all flowers
    }

    /**
     * Main method to test the canPlaceFlowers function.
     */
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1}; // Initial flowerbed
        int n = 1; // Number of flowers to plant

        // Output the result
        System.out.println("Can new flowers be planted? : " + canPlaceFlowers(flowerbed, n));
    }
}
