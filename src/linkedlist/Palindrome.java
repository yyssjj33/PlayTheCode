package linkedlist;

public class Palindrome {
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode newHead = new ListNode(head.val);
		ListNode iter = head.next;
		while (iter != null) {
			ListNode temp = new ListNode(iter.val);
			temp.next = newHead;
			newHead = temp;
			iter = iter.next;
		}

		while (head != null && newHead != null) {
			if (head.val != newHead.val)
				return false;
			head = head.next;
			newHead = newHead.next;
		}
		return true;
	}
	
		public static boolean isPalindrome2(ListNode head){
			
			//spreate into 2 parts
			ListNode fast = head;
			ListNode slow = head;
			while(fast.next!=null && fast.next.next!=null){
				fast = fast.next.next;
				slow = slow.next;
			}
			
			ListNode p1 = head;
			ListNode p2 = slow.next;
			slow = null;
			//reverse p2
			ListNode cur = p2;
			ListNode prev = null;
			while(cur!=null){
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			
			while(prev!=null){
				if(prev.val!=head.val)
					return false;
				head = head.next;
				prev =prev.next;
			}
			return true;
		}
	
	public static void main(String[] args){
		ListNode list = new ListNode(5);
		list.next = new ListNode(4);
		list.next.next = new ListNode(2);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);
		
		System.out.print(isPalindrome2(list));
		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}
}
