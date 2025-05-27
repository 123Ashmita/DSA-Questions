package com.day21;

import java.util.PriorityQueue;

/**
 * This class provides a method to merge k sorted linked lists into one sorted list.
 * It uses a min-heap (PriorityQueue) to always choose the smallest head node
 * among the k lists.
 */
public class MergeKList {

    /**
     * Definition for singly-linked list node.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Merges k sorted linked lists into one sorted linked list.
     *
     * @param lists An array of ListNode objects, each representing the head of a sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // Define a min-heap (priority queue) to always get the node with the smallest value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Step 1: Add the head of each list to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node); // Only add non-null nodes
            }
        }

        // Step 2: Use a dummy node to simplify result list building
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Step 3: Extract the smallest node and add the next node from the same list to the queue
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();      // Get node with the smallest value
            current.next = smallest;            // Append it to the result list
            current = current.next;             // Move the pointer

            if (smallest.next != null) {
                pq.offer(smallest.next);        // Add the next node of the list to the queue
            }
        }

        // Return the head of the merged list (skipping dummy node)
        return dummy.next;
    }

    /**
     * Main method to test the mergeKLists function with sample data.
     */
    public static void main(String[] args) {
        MergeKList outer = new MergeKList();

        // Create first sorted list: 1 -> 4 -> 5
        ListNode l1 = outer.new ListNode(1);
        l1.next = outer.new ListNode(4);
        l1.next.next = outer.new ListNode(5);

        // Create second sorted list: 1 -> 3 -> 4
        ListNode l2 = outer.new ListNode(1);
        l2.next = outer.new ListNode(3);
        l2.next.next = outer.new ListNode(4);

        // Create third sorted list: 2 -> 6
        ListNode l3 = outer.new ListNode(2);
        l3.next = outer.new ListNode(6);

        // Combine all lists into an array
        ListNode[] lists = new ListNode[]{l1, l2, l3};

        // Call merge function
        ListNode result = outer.mergeKLists(lists);

        // Print merged list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
