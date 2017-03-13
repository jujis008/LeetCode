package com.wilson.leetcode;

import java.util.Scanner;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ListNode node1 = null;
		ListNode node2 = null;
		System.out.println("Please input number for node1: ");
		int n = scanner.nextInt();
		node1 = new ListNode(n);
		while (n != -1) {
			n = scanner.nextInt();
			ListNode node = new ListNode(n);
			node1.next = node;
		}
		printNode(node1);
		
		System.out.println("Please input number for node2: ");
		int m = scanner.nextInt();
		node2 = new ListNode(m);
		while (m != -1) {
			m = scanner.nextInt();
			ListNode node = new ListNode(m);
			node2.next = node;
		}
		printNode(node2);
		scanner.close();
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return new ListNode(0);
		} else if (l1 == null || l2 == null) {
			if (l1 != null) {
				return l1;
			} else {
				return l2;
			}
		}
		int last = 0;
		while (l1 != null) {
			int flag = 0;
			l1.val += l2.val;
			l1.val += last;
			if (l1.val >= 10) {
				l1.val %= 10;
				flag = 1;
			}
			l1 = l1.next;
			if (l2 != null) {
				l2 = l2.next;
			}
			last = flag;
		}
		if (l2 != null) {
			l1.next = l2.next;
		}
		return l1;
	}
	
	public static void printNode(ListNode node){
		ListNode tmpNode = node;
		while (tmpNode.next != null) {
			System.out.print(tmpNode.val +" ");
			tmpNode.next = node.next;
		}
		System.out.println();
	}
}
