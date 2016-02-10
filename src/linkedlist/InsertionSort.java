package linkedlist;

public class InsertionSort {
	public static ListNode insertionSort(ListNode head){
		ListNode dummy = new ListNode(0);
		ListNode cur = head;
		while(cur!=null){
			ListNode next = cur.next;
			insert(dummy, cur);
			cur = next;
		}
		return dummy.next;
	}
	
	public static void insert(ListNode dummyHead, ListNode target){
		ListNode cur = dummyHead;
		while(cur.next!=null && cur.next.val < target.val){
			cur = cur.next;
		}
		target.next = cur.next;
		cur.next = target;
	}
	
	public static void main(String[] args){
		ListNode list = new ListNode(5);
		list.next = new ListNode(4);
		list.next.next = new ListNode(10);
		list.next.next.next = new ListNode(9);
		
		ListNode out = insertionSort(list);
		while (out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}
	}
}
