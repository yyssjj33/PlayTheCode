package linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class LNComparator implements Comparator<ListNode>{
	public int compare(ListNode l1, ListNode l2){
		return l1.val - l2.val;
	}
}

public class MergeKSortedLists {

	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
		public int compare(ListNode l1, ListNode l2){
			if (l1 == null)
				return 1;
			else if (l2 == null)
				return -1;
			return l1.val-l2.val;
		}
	};
	public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
		Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
		for (int i = 0; i < lists.size(); i++){
			if (lists.get(i) != null)
				pq.add(lists.get(i));
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (!pq.isEmpty()){
			ListNode temp = pq.poll();
			cur.next = temp;
			cur = cur.next;
			if (temp.next != null){
				pq.add(temp.next);
			}
		}
		return dummy.next;

		
    }
	


	
	public static void main(String[] args) {
		
		
	}

}
