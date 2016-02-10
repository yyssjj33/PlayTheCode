package linkedlist;

public class MergeSort {
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// break into 2 part
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;

		}
		ListNode left = head;
		ListNode right = slow.next;
		slow.next = null;

		// Recursion
		ListNode h1 = sortList(left);
		ListNode h2 = sortList(right);

		// merge

		ListNode merged = merge(h1, h2);
		return merged;
	}

	public static ListNode merge(ListNode h1, ListNode h2) {
		ListNode dummy = new ListNode(0);
		ListNode iter = dummy;
		ListNode p1 = h1;
		ListNode p2 = h2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				iter.next = p1;
				p1 = p1.next;
			} else {
				iter.next = p2;
				p2 = p2.next;
			}
			iter = iter.next;
		}
		if (p1 != null)
			iter.next = p1;
		if (p2 != null)
			iter.next = p2;

		return dummy.next;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(0);

		ListNode out = sortList(head);
		while (out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}
	}
}