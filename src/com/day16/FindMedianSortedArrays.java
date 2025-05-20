package com.day16;

import java.util.Arrays;

/**
 * This class provides a method to find the median of two sorted arrays.
 */
public class FindMedianSortedArrays {

    /**
     * This method finds the median of two sorted arrays.
     *
     * @param nums1 the first sorted array
     * @param nums2 the second sorted array
     * @return the median of the two arrays
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Length of the first and second array
        int n = nums1.length;
        int m = nums2.length;

        // Create a new array to hold the merged arrays
        int[] merged = new int[n + m];
        int k = 0;

        // Copy elements from nums1 to the merged array
        for (int i = 0; i < n; i++) {
            merged[k++] = nums1[i];
        }

        // Copy elements from nums2 to the merged array
        for (int i = 0; i < m; i++) {
            merged[k++] = nums2[i];
        }

        // Sort the merged array
        Arrays.sort(merged);

        // Total length of the merged array
        int total = merged.length;

        // If the total length is odd, return the middle element
        if (total % 2 == 1) {
            return (double) merged[total / 2];
        } else {
            // If the total length is even, calculate the average of the two middle elements
            int middle1 = merged[total / 2 - 1];
            int middle2 = merged[total / 2];
            return ((double) middle1 + (double) middle2) / 2.0;
        }
    }

    public static void main(String[] args) {
        // Test case 1: First array is {1, 3}, second array is {2}
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        
        // Print the result of finding the median of the two arrays
        System.out.println("Median of two sorted arrays: " + findMedianSortedArrays(nums1, nums2));
    }
}
