package com.day14;

import java.util.PriorityQueue;

/*
 * This class is used to find the kth largest element in an array.
 * For example, given the array nums = {3,2,3,1,2,4,5,5,6} and k = 4,
 * the method will return the 4th largest element in the array, which is 4.
 */
public class FindKthLargest {

    /*
     * This method finds the kth largest element in the given array.
     * It uses a min-heap (PriorityQueue) of size k to keep track of the top k largest elements.
     * 
     * @param nums - the array of integers
     * @param k - the position of the largest element to find
     * @return - the kth largest element
     */
    public static int findKthLargest(int[] nums, int k) {
        // Create a min-heap using PriorityQueue
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();

        // Loop through each number in the array
        for(int i = 0; i < nums.length; i++) {
            // If the heap size is less than k, add the number to the heap
            if(min.size() < k) {
                min.add(nums[i]);
            }
            // If the current number is greater than the smallest in the heap
            else if(nums[i] > min.peek()) {
                // Remove the smallest and add the current number
                min.poll();
                min.add(nums[i]);
            }
        }

        // The top of the heap is the kth largest element
        return min.peek();
    }

    // Main method to test the findKthLargest method
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};  // Input array
        int k = 4;  // We want to find the 4th largest element
        System.out.println("Largest kth element in nums: " + findKthLargest(nums, k));
    }
}
