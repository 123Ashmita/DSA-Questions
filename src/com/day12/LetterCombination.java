package com.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class to generate all possible letter combinations 
 * for a given digit string as per the mapping on a phone keypad.
 */
public class LetterCombination {

    /**
     * Returns all possible letter combinations for the given digits.
     * 
     * @param digits the input digit string (example "23")
     * @return a list of all possible letter combinations
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Return empty list if input is null or empty
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Mapping of digits to corresponding letters (like a phone keypad)
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // Start backtracking to find all combinations
        backtrack(digits, 0, new StringBuilder(), result, map);
        return result;
    }

    /**
     * Helper method to perform backtracking and generate combinations.
     * 
     * @param digits the input digit string
     * @param index current position in the digits string
     * @param current the current combination being built
     * @param result the list storing all valid combinations
     * @param map the digit-to-letters mapping
     */
    private static void backtrack(String digits, int index, StringBuilder current,
                                  List<String> result, Map<Character, String> map) {
        // If the current combination is complete, add to result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters mapped to the current digit
        String letters = map.get(digits.charAt(index));

        // Try each letter and continue backtracking
        for (char c : letters.toCharArray()) {
            current.append(c); 
            backtrack(digits, index + 1, current, result, map); 
            current.deleteCharAt(current.length() - 1);  
        }
    }

    /**
     * Main method to test the letterCombinations method.
     */
    public static void main(String[] args) {
        String digits = "23";
        System.out.println("Letter Combination : " + letterCombinations(digits));
    }
}
