package com.day16;

import java.util.PriorityQueue;

/**
 * This class provides a method to calculate the total cost of choosing `k` candidates from a list of costs.
 * It uses two priority queues (heaps) to efficiently select the least costly candidates from the two ends.
 */
public class TotalCost {

    /**
     * This method calculates the total cost for selecting `k` candidates, where candidates are chosen from the 
     * beginning and end of the costs array, while ensuring no more than `candidates` are chosen from either side.
     *
     * @param costs an array of integers representing the cost of selecting each candidate
     * @param k the number of candidates to be chosen
     * @param candidates the maximum number of candidates that can be selected from either end
     * @return the total cost for selecting `k` candidates
     */
    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int left = 0, right = n - 1;
        long total = 0;

        // Priority queues (min-heaps) to select the smallest costs from both ends of the array
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        // Fill the heaps with the first `candidates` elements from both the left and right ends
        while (leftHeap.size() < candidates && left <= right)
            leftHeap.offer(costs[left++]);
        while (rightHeap.size() < candidates && right >= left)
            rightHeap.offer(costs[right--]);

        // Select `k` candidates by repeatedly picking the least costly option from the heaps
        for (int i = 0; i < k; i++) {
            // If right heap is empty or left heap's smallest cost is less than or equal to right heap's smallest
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {
                total += leftHeap.poll();  // Add the least costly candidate from the left heap
                if (left <= right)         // Add the next candidate from the left side if available
                    leftHeap.offer(costs[left++]);
            } else {
                total += rightHeap.poll(); // Add the least costly candidate from the right heap
                if (left <= right)         // Add the next candidate from the right side if available
                    rightHeap.offer(costs[right--]);
            }
        }

        return total;  // Return the total cost of the selected candidates
    }

    public static void main(String[] args) {
        // Example test case: an array of costs, the number of candidates to choose, and the max number of candidates from either side
        int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3;
        int candidates = 4;

        // Print the total cost for selecting `k` candidates
        System.out.println(totalCost(costs, k, candidates));
    }
}
