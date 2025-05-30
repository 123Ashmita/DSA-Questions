package com.day22;

/**
 * Class to reverse nodes of a singly linked list in groups of size k.
 */
public class ReverseKNodes {

    /**
     * Definition for singly-linked list node.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Reverses nodes of the linked list in groups of k and returns the new head.
     * 
     * @param head The head of the linked list
     * @param k    The number of nodes in each group to reverse
     * @return     The new head of the modified list
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Check if there are at least k nodes ahead
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If we have at least k nodes, we reverse them
        if (count == k) {
            // Recursively call for the rest of the list
            ListNode prev = reverseKGroup(curr, k);

            // Now reverse current k nodes
            while (count-- > 0) {
                ListNode temp = head.next;  // Save next node
                head.next = prev;           // Reverse the pointer
                prev = head;                // Move prev forward
                head = temp;                // Move head forward
            }

            return prev; // prev is the new head after reversing k nodes
        }

        // If fewer than k nodes are left, return head without changes
        return head;
    }

    /**
     * Main method to test the reverseKGroup function.
     */
    public static void main(String[] args) {
        ReverseKNodes outer = new ReverseKNodes();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = outer.new ListNode(1);
        head.next = outer.new ListNode(2);
        head.next.next = outer.new ListNode(3);
        head.next.next.next = outer.new ListNode(4);
        head.next.next.next.next = outer.new ListNode(5);

        int k = 2; // Size of group to reverse

        // Call the reverseKGroup method
        ListNode result = outer.reverseKGroup(head, k);

        // Print the reversed list
        System.out.println("Updated linked list : ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
