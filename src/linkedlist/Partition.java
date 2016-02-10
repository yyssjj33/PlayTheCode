package linkedlist;


 
public class Partition {
	public static ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode smaller = new ListNode(0);
        ListNode larger = new ListNode(0);
        ListNode smallerIter = smaller, largerIter = larger;
        ListNode cur = head;
        while(cur != null){
            if (cur.val < x){
            	ListNode temp = cur.next;
                smallerIter.next = cur;
                cur.next = null;
                smallerIter = smallerIter.next;
                cur = temp;
            }else{
            	ListNode temp = cur.next;
                largerIter.next = cur;
                cur.next = null;
                largerIter = largerIter.next;
                cur = temp;
                
            }
        }
        smallerIter.next = larger.next;
        return smaller.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next =new ListNode(3);
		head.next.next.next= new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next =new ListNode(2);
		
		ListNode r = partition(head, 3);
		while(r!=null){
			System.out.print(r.val+" ");
			r=r.next;
		}
	}
}
