package com.day8;

import java.util.Queue;
import java.util.LinkedList;

/**
 * This class simulates a stack using a single queue.
 * Stack operations (push, pop, top, empty) are implemented using queue operations.
 */
class MyStack {

    private Queue<Integer> queue;

    /**
     * Constructor to initialize the internal queue.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Pushes an element onto the stack.
     * The new element is added to the queue and then rotated to the front.
     *
     * @param x the element to be pushed
     */
    public void push(int x) {
        queue.add(x); // Add to rear of queue
        int size = queue.size();
        
        // Rotate the queue to bring the new element to the front
        for (int i = 1; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    /**
     * Removes the element on top of the stack and returns it.
     *
     * @return the top element
     */
    public int pop() {
        return queue.remove(); // Remove from front of queue
    }

    /**
     * Gets the top element of the stack without removing it.
     *
     * @return the top element
     */
    public int top() {
        return queue.peek(); // Peek front element
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Driver class to test the MyStack implementation.
 */
public class ImplementStackUsingQueue {

	 public static void main(String[] args) {
	        // Step-by-step test like LeetCode input/output
	        MyStack stack = new MyStack();          // ["MyStack"]
	        System.out.print("null" + " ");             // Corresponds to constructor

	        stack.push(1);                          // ["push", [1]]
	        System.out.print("null" + " ");

	        stack.push(2);                          // ["push", [2]]
	        System.out.print("null" + " ");

	        System.out.print(stack.top() + " ");        // ["top"] -> 2

	        System.out.print(stack.pop() + " ");        // ["pop"] -> 2

	        System.out.print(stack.empty() + " ");      // ["empty"] -> false
	    }
}
