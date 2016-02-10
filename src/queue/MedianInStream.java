package queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInStream {

	public static int[] medianII(int[] nums) {
        // write your code here
		if (nums.length < 1) return null;
		int[] res = new int[nums.length]; 
		res[0] = nums[0];
		int med = res[0];
		PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer i, Integer j){
				return j - i;
			}
		});
		PriorityQueue<Integer> minq = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer i, Integer j){
				return i - j;
			}
		});
		
		for (int i = 1; i < nums.length; i++){
			int cur = nums[i];
			if (cur < med){
				maxq.add(cur);
			}else{
				minq.add(cur);
			}
			
			if (minq.size() > maxq.size() + 1){
				maxq.add(med);
				med = minq.poll();
				
			}else if (minq.size()  < maxq.size()){
				minq.add(med);
				med = maxq.poll();
			}
			res[i] = med;
			
		}
		
		
		
		return res;
    }
	public static void main(String[] args) {
		int[] input = {1, 2,2, 3, 4, 5};
		
		int[] res = medianII(input);
		System.out.println(Arrays.toString(res));
	}
}
