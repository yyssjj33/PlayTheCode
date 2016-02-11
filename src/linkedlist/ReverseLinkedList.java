package linkedlist;

public class ReverseLinkedList {
	public static ListNode reverse(ListNode head){
		
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode newHead = reverse(head.next);
		
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		
		ListNode newHead = reverse(head);
		
		while(newHead!=null){
			System.out.print(newHead.val+" ");
			newHead = newHead.next;
		}
	}
}
