package com.day15;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class counts how many ping requests happened in the last 3000 milliseconds.
 */
public class RecentCounter {
	
    // This queue stores the times of the ping requests
    Queue<Integer> queue;

    /**
     * Constructor to create a new RecentCounter.
     */
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    /**
     * This method adds a new ping request at time t.
     * It removes all old pings that are more than 3000ms before t.
     *
     * @param t the time of the new ping
     * @return the number of pings in the last 3000ms (including this one)
     */
    public int ping(int t) {
        // Add the new ping time to the queue
        queue.add(t);
        
        // Remove all pings that are too old (more than 3000ms ago)
        while (!queue.isEmpty() && t - 3000 > queue.peek()) {
            queue.poll(); // remove the oldest ping
        }

        // Return how many pings are left in the time window
        return queue.size();
    }

    /**
     * Main method to test the RecentCounter class.
     */
    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();

        // Test the ping method with sample times
        System.out.print(counter.ping(1) + " ");    // Output: 1
        System.out.print(counter.ping(100) + " ");  // Output: 2
        System.out.print(counter.ping(3001) + " "); // Output: 3
        System.out.print(counter.ping(3002) + " "); // Output: 3
    }
}
