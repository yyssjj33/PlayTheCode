package linkedlist;

public class IsSubset {

	public static boolean isSubset(ListNode list, ListNode sub) {
	
		ListNode listIter = list;
		ListNode subIter = sub;
		
		while (listIter != null) {
			if(subIter == null)
				return false;
			if (listIter.val == subIter.val) {
				if (subIter.next == null) {
					return true;
				} else {
					listIter = listIter.next;
					subIter = subIter.next;
		
				}
			}
			if (listIter.val < subIter.val) {
				listIter = listIter.next;
				
			}
			if (listIter.val > subIter.val ) {
				subIter = subIter.next;
				
			}

		}
		return false;
	}
	
	public static void main(String[] args){
		ListNode list = new ListNode(2);
		list.next = new ListNode(4);
		list.next.next = new ListNode(6);
		list.next.next.next = new ListNode(9);
		
		ListNode sub = new ListNode(5);
		sub.next = new ListNode(9);
		
		System.out.println(isSubset(list,sub));
	}
}
