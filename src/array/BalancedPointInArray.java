package array;

import java.util.ArrayList;
import java.util.Random;

public class BalancedPointInArray {
	public static ArrayList<Integer> naiveWay(int[] array){
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++){
			int left = 0, right = 0;
			
			for (int j = 0; j < i; j++){
				left += array[j];
			}
			for (int k = i+1; k < array.length; k++){
				right += array[k];
			}
			if (left == right)
				res.add(array[i]);
		}
		
		return res;
	}
	
	public static ArrayList<Integer> optWay(int[] array){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		int[] leftToRight = new int[array.length];
		int[] rightToLeft = new int[array.length];
		leftToRight[0] = array[0];
		rightToLeft[array.length-1] = array[array.length-1];
		for (int i = 1; i < array.length; i++){
			leftToRight[i] = leftToRight[i-1]+array[i];
		}
		for (int i = array.length-2; i >= 0; i--){
			rightToLeft[i] = rightToLeft[i+1]+array[i];
		}
		for (int i = 0; i < array.length; i++){
			if (leftToRight[i] == rightToLeft[i])
				res.add(array[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		int[] nums =  new int[100000];
		Random r = new Random(1000);
		for (int i = 0; i < 100000; i++){
			nums[i] = r.nextInt(100);
		}
		long time = System.currentTimeMillis();
		System.out.println(naiveWay(nums));
		System.out.println(System.currentTimeMillis()-time);
	}
}
