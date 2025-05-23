package com.day19;

import java.util.Arrays;

/**
 * This class contains a method to determine if two strings are "close."
 * Two strings are considered close if:
 * 1. They have the same set of characters.
 * 2. The frequency of characters can be rearranged to match each other.
 */
public class CloseStrings {

    /**
     * Checks if two strings are close.
     *
     * @param word1 the first input string
     * @param word2 the second input string
     * @return true if the strings are close, false otherwise
     */
    public boolean closeStrings(String word1, String word2) {
        // If lengths are not equal, they can't be close
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26]; // Frequency array for word1
        int[] freq2 = new int[26]; // Frequency array for word2

        // Count character frequencies for both words
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Check if both strings use the same set of characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0))
                return false;
        }

        // Sort the frequency arrays to compare frequency patterns
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2); // Return true if frequency patterns match
    }

    //main method to test input case
    public static void main(String[] args) {
        CloseStrings obj = new CloseStrings();

        // Test examples
        String word1 = "abc";
        String word2 = "bca";

        System.out.println("Are the strings close? " + obj.closeStrings(word1, word2));
    }
}
