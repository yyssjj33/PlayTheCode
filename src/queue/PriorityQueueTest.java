package queue;


import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static int findKthLatgest(int[] nums, int k){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < nums.length; i++){
			if(q.size()<k){
				q.add(nums[i]);
			}else{
				if (nums[i] < q.peek())
					continue;
				else{
					q.poll();
					q.add(nums[i]);
				}
				
			}
			
		}
		return q.poll();
	}
	
	public static void main(String[] args) {
		System.out.println(findKthLatgest(new int[]{9,2,3,4,5,6,7,8}, 3));
	}
	
	
}
