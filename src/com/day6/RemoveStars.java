package com.day6;


/**
 * A simple program to remove characters from a string
 * where each '*' removes the character just before it.
 *
 * For example:
 * Input: "leet**cod*e"
 * Output: "lecoe"
 */
public class RemoveStars {

    /**
     * This method removes the character before every '*' in the string.
     *
     * @param s The input string that may contain '*' characters
     * @return The string after removing characters based on '*'
     */
    public static String removeStars(String s) {
        // Create an array to store characters after removal
        char[] arr = new char[s.length()];
        int i = 0; // Pointer to keep track of the position in the array

        // Loop through the string
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);  // Get the current character

            if (c == '*') {
                // If it's a '*', remove the previous character by decreasing the pointer
                i--;
            } else {
                // Otherwise, add the current character to the array
                arr[i] = c;
                i++;
            }
        }

        // Create a StringBuilder to store the result
        StringBuilder sb = new StringBuilder();
        
        // Append the characters that were not removed
        for (int j = 0; j < i; j++) {
            sb.append(arr[j]);
        }

        // Return the resulting string
        return sb.toString();
    }

    /**
     * Main method to test the removeStars method.
     */
    public static void main(String[] args) {
        String input = "leet**cod*e";  // Example input string
        // Print the result after removing characters using '*'
        System.out.println("Output: " + removeStars(input));
    }
}
