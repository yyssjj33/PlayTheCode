package array;

import java.util.Arrays;

public class ProductExpSelf {
	public static int[] productExpSelf(int[] nums){
		int len = nums.length;
		int[] result = new int[len]; result[0]=1;
		int p = 1;
		for(int i = 1; i < len; i++){
			result[i] = 1;
			result[i] = result[i-1]*nums[i-1];
		}
		for(int i = len-1; i >= 0; i--){
			
			result[i]*=p;
			p*=nums[i];
		}

		
		return result;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,4};
		a = productExpSelf(a);
		System.out.println(Arrays.toString(a));
		
	}
}
