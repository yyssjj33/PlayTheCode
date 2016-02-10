package array;

import java.util.Arrays;

public class RotateArrayAtK {
	public void rotateAtK(int[] nums, int k){
		reverseAt(nums,0,k);
		reverseAt(nums,k+1,nums.length-1);
		reverseAt(nums,0,nums.length-1);
	}
	
	private  void reverseAt(int[] nums, int i, int j){
		while(i<=j){
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
		
	}
	
	public static void main(String[] args){
		RotateArrayAtK test = new RotateArrayAtK();
		int[] arr = {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(arr));
		test.rotateAtK(arr, 3);
		System.out.println(Arrays.toString(arr));
		
		
	}
}
