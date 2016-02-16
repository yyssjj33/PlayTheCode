package array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {
	public static int findKthLargest(int[] nums, int k){
		if (k < 0 || k > nums.length)
			return -1;
		return findKthLargest(nums, 0, nums.length-1, k);
	}
	
	public static int findKthLargest(int[] nums, int start, int end, int k){
		int pivot = start;
		int left = start;
		int right = end;
		while (left <= right){
			while (left <= right && nums[left] >= nums[pivot])
				left++;
			while (left <= right && nums[right] <= nums[pivot])
				right--;
			if (left < right)
				swap(nums, left, right);
		}
		swap(nums, pivot, right);
		if (k == right + 1)//k is 1 to nums.length based
			return nums[right];
		else if (k > right + 1)
			return findKthLargest(nums, right+1, end, k);
		else 
			return findKthLargest(nums, start, right-1, k);

	}
	public static int findKthLargest2(int[] nums, int k){
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
	
	private static void swap (int[] nums, int a, int b){
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[20];
		Random r = new Random();
		for (int i = 0; i < 20 ; i++){
			nums[i] = r.nextInt(100);
		}
		System.out.println(Arrays.toString(nums));
		System.out.println(findKthLargest(new int[] {-1,2,0},1));
		System.out.println(findKthLargest2(new int[] {-1,2,0},1));

	}

}


