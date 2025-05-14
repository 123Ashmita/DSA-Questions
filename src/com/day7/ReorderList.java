package com.day7;

public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle
        ListNode start = head;
        ListNode end = head;
        while (end != null && end.next != null && end.next.next != null) {
            start = start.next;
            end = end.next.next;
        }

        // Step 2: Reverse second half
        end = reverseList(start.next);
        start.next = null;

        // Step 3: Merge two halves
        start = head;
        while (end != null) {
            ListNode temp1 = start.next;
            ListNode temp2 = end.next;

            start.next = end;
            end.next = temp1;

            start = temp1;
            end = temp2;
        }
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reorder list
        ReorderList solution = new ReorderList();
        solution.reorderList(head);

        // Print the reordered list
        printList(head); // Output: 1 -> 5 -> 2 -> 4 -> 3
    }
}
