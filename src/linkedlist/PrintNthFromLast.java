package linkedlist;

public class PrintNthFromLast {
	public static int printNthFromLast(ListNode list, int n){
		ListNode fast = list;
		ListNode slow = list;
		for(int i = 0; i < n; i++){
			if(fast==null) {return -1;}
			fast = fast.next;
		}
		
		while(fast!=null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow.val;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		System.out.println(printNthFromLast(head,4));
	}
}
