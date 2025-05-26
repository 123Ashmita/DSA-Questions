package com.day20;

import java.util.Arrays;

/**
 * This class helps sort an array of integers using Heap Sort.
 * Heap Sort is fast (O(n log n)) and works directly on the array (no extra space).
 */
public class SortAray {

    /**
     * Sorts the given array in ascending order using Heap Sort.
     *
     * @param nums The array of numbers to sort
     * @return The sorted array
     */
    public static int[] sortArray(int[] nums) {
        heapSort(nums); // Call the heap sort function
        return nums;
    }

    /**
     * This function sorts the array using Heap Sort.
     * It first builds a max heap, then repeatedly moves the largest element to the end.
     *
     * @param arr The array to be sorted
     */
    private static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build a max heap (largest number on top)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Move the largest number (root) to the end and shrink the heap
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);         // Move root to end
            heapify(arr, i, 0);      // Heapify the reduced heap
        }
    }

    /**
     * Makes sure the tree rooted at index i is a max heap.
     * If not, it swaps the values and calls itself recursively.
     *
     * @param arr The array (heap)
     * @param n   Size of the heap
     * @param i   Index of the root node
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;          // Assume current node is largest
        int left = 2 * i + 1;     // Left child
        int right = 2 * i + 2;    // Right child

        // Check if left child is bigger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is bigger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not the current node, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param arr The array
     * @param i   First index
     * @param j   Second index
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Main method to test the sort function.
     */
    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};                   // Sample input
        int[] sorted = sortArray(nums);                    // Sort the array
        System.out.println(Arrays.toString(sorted));       // Print sorted array
    }
}
