package linkedlist;

public class ReverseLinkedListII {
	public static  ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode cur = head;
        ListNode prev = null;
        for (int i = 0; i < m-1; i++){
            prev = cur;
            cur = cur.next;
        }
        ListNode newTail = prev;
        ListNode newHead = cur;
        for (int i = m; i <= n; i++){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            
        }
        newTail.next = prev;
        newHead.next = cur;
        
        return head;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next =new ListNode(3);
		head.next.next.next= new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode h = reverseBetween(head,2,4);
		
		while(h!=null){
			System.out.print(h.val+" ");
			h=h.next;
		}
	}
}
