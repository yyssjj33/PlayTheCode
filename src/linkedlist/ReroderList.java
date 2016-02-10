package linkedlist;

public class ReroderList {
	public static void reorderList(ListNode head) {
		// write your code here
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		// split into 2 part
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		fast = slow.next;
		slow.next = null;
		slow = head;
		// reverse second part
		ListNode prev = null;
		while (fast != null) {
			ListNode temp = fast.next;
			fast.next = prev;
			prev = fast;
			fast = temp;
		}
		// prev is new head of second part now
		ListNode cur = slow;
		while (slow != null && prev != null) {
			ListNode temp = slow.next;
			ListNode temp2 = prev.next;
			cur.next = prev;
			cur = cur.next;
			cur.next = temp;
			cur = cur.next;
			slow = temp;
			prev = temp2;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(0);
		reorderList(head);
	}
}
