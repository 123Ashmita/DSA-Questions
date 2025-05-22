package com.day18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class provides a method to find distinct elements between two arrays.
 * It returns a list of two lists:
 * - The first list contains elements that are only in nums1.
 * - The second list contains elements that are only in nums2.
 * 
 * Example:
 * Input: nums1 = [1, 2, 3], nums2 = [2, 4, 6]
 * Output: [[1, 3], [4, 6]]
 */
public class FindDifference {

    /**
     * Finds all distinct integers that are only in one of the two arrays.
     *
     * @param nums1 the first array of integers
     * @param nums2 the second array of integers
     * @return a list containing two lists:
     *         - Elements only in nums1
     *         - Elements only in nums2
     */
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Create sets to remove duplicates and allow for set operations
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Fill sets with array values
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        // Create copies for performing difference operations
        Set<Integer> onlyInNums1 = new HashSet<>(set1);
        Set<Integer> onlyInNums2 = new HashSet<>(set2);

        // Remove elements found in the opposite set
        onlyInNums1.removeAll(set2); // Now contains elements only in nums1
        onlyInNums2.removeAll(set1); // Now contains elements only in nums2

        // Convert sets back to lists
        List<Integer> list1 = new ArrayList<>(onlyInNums1);
        List<Integer> list2 = new ArrayList<>(onlyInNums2);

        // Combine both lists into the final answer
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(list1);
        answer.add(list2);

        return answer;
    }

    /**
     * Main method to test the findDifference method.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        // Expected output: [[1, 3], [4, 6]]
        System.out.println("All distinct Integers : " + findDifference(nums1, nums2));
    }
}
