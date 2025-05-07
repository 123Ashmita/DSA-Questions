package com.day3;

import java.util.Stack;

public class IsPalindromeLinkedList {
	class ListNode {
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

	public static boolean isPalindrome(ListNode head) {
		ListNode curr = head;
		Stack<Integer> s = new Stack<>();
		while (curr != null) {
			s.push(curr.val);
			curr = curr.next;
		}
		while (head != null) {
			int c = s.pop();
			if (head.val != c) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public static void main(String[] args) {

		IsPalindromeLinkedList subsets = new IsPalindromeLinkedList();

		ListNode l1 = subsets.new ListNode(1);
		l1.next = subsets.new ListNode(2);
		l1.next.next = subsets.new ListNode(2);
		l1.next.next.next=subsets.new ListNode(1);
		System.out.println(isPalindrome(l1));

	}

}
