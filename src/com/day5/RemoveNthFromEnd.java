package com.day5;

public class RemoveNthFromEnd {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode ptr1 = dummy;
		ListNode ptr2 = dummy;
		for (int i = 0; i < n; i++) {
			ptr2 = ptr2.next;
		}
		while (ptr2.next != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		ptr1.next = ptr1.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
	    ListNode ln = new ListNode(1);
	    ln.next = new ListNode(2);
	    ln.next.next = new ListNode(3);
	    ln.next.next.next = new ListNode(4);
	    ln.next.next.next.next = new ListNode(5);

	    int n = 2;
	    ListNode updatedHead = removeNthFromEnd(ln, n);

	    // Print the updated list
	    while (updatedHead != null) {
	        System.out.print(updatedHead.val + " ");
	        updatedHead = updatedHead.next;
	    }
	}

}
