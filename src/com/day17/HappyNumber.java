package com.day17;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains a method to determine whether a number is a "happy number."
 * A happy number is a number that eventually reaches 1 when replaced by the sum 
 * of the squares of its digits repeatedly. If it enters a cycle that does not include 1, 
 * it is considered an unhappy number.
 */
public class HappyNumber {

    /**
     * Determines if the given number is a happy number.
     *
     * @param n the number to check
     * @return true if the number is happy, false otherwise
     */
    public static boolean isHappy(int n) {
        // Set to track numbers we've already seen to detect cycles
        Set<Integer> usedIntegers = new HashSet<>();

        while (true) {
            int sum = 0;

            // Calculate sum of squares of digits
            while (n != 0) {
                int digit = n % 10;
                sum += Math.pow(digit, 2);
                n = n / 10;
            }

            // If the sum is 1, it's a happy number
            if (sum == 1) return true;

            // If we've seen this sum before, it's a cycle (not a happy number)
            if (usedIntegers.contains(sum))
                return false;

            // Otherwise, continue the process with the new number
            usedIntegers.add(sum);
            n = sum;
        }
    }

    /**
     * Main method to test the isHappy function with example inputs.
     */
    public static void main(String[] args) {
        int n1 = 19;
        int n2 = 2;

        System.out.println("Is Happy (" + n1 + "): " + isHappy(n1)); // true
        System.out.println("Is Happy (" + n2 + "): " + isHappy(n2)); // false
    }
}
