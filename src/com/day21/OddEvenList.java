package com.day21;

/**
 * This class provides a method to rearrange a singly-linked list such that
 * all odd-indexed nodes come first, followed by the even-indexed nodes.
 * Indexing starts from 1 (not 0), so head is odd.
 */
public class OddEvenList {

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
     * Rearranges the linked list such that all odd-positioned nodes are grouped
     * together followed by even-positioned nodes.
     *
     * @param head The head of the original singly-linked list.
     * @return The head of the rearranged list.
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head; // Handle edge case: empty list

        // Pointers for odd and even nodes
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // To connect after odd list ends

        // Rearranging nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next;   // Link odd nodes together
            odd = odd.next;

            even.next = even.next.next; // Link even nodes together
            even = even.next;
        }

        // Join odd list with even list
        odd.next = evenHead;

        return head;
    }

    /**
     * Main method to test the oddEvenList rearrangement with a sample linked list.
     */
    public static void main(String[] args) {
        OddEvenList outer = new OddEvenList();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = outer.new ListNode(1);
        head.next = outer.new ListNode(2);
        head.next.next = outer.new ListNode(3);
        head.next.next.next = outer.new ListNode(4);
        head.next.next.next.next = outer.new ListNode(5);

        // Apply oddEvenList rearrangement
        ListNode result = outer.oddEvenList(head);

        // Print rearranged list: Expected output: 1 -> 3 -> 5 -> 2 -> 4
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
