package com.day12;

import java.util.Stack;

/**
 * The DecodeString class provides a method to decode encoded strings
 * that follow a pattern like k[encoded_string], where the encoded_string
 * inside the square brackets is repeated exactly k times.
 * 
 * Example:
 * Input: "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */
public class DecodeString {

    /**
     * Decodes an encoded string where numbers followed by brackets represent
     * repetition of characters.
     *
     * @param s the encoded input string (e.g., "3[a2[c]]")
     * @return the fully decoded string (e.g., "accaccacc")
     */
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int k = 0;

        // Traverse each character in the input string
        for (char c : s.toCharArray()) {

            // If character is a digit, build the number k
            if (Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
                continue;
            }

            // If character is an opening bracket '[', push the number and reset k
            if (c == '[') {
                numStack.push(k);
                k = 0;
                stringStack.push(String.valueOf(c));
                continue;
            }

            // If character is not ']', push it to string stack
            if (c != ']') {
                stringStack.push(String.valueOf(c));
                continue;
            }

            // When ']' is encountered, build the substring inside the brackets
            StringBuilder temp = new StringBuilder();
            while (!stringStack.peek().equals("[")) {
                temp.insert(0, stringStack.pop());
            }

            // Remove the opening bracket '['
            stringStack.pop();

            // Pop the repeat count from number stack
            int count = numStack.pop();

            // Repeat the decoded substring count times
            StringBuilder replacement = new StringBuilder();
            for (int i = 0; i < count; i++) {
                replacement.append(temp);
            }

            // Push the repeated string back to the stack
            stringStack.push(replacement.toString());
        }

        // Build the final result from the stack
        StringBuilder result = new StringBuilder();
        while (!stringStack.empty()) {
            result.insert(0, stringStack.pop());
        }

        return result.toString();
    }

    /**
     * Main method to test the decodeString method with a sample input.
     */
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println("Decoded String : " + decodeString(s));
    }

}
