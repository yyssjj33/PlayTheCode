package array;

import java.util.ArrayList;

public class SubsetsLintCode {
	public static ArrayList<ArrayList<Integer>> subsets(int[] nums){
		if(nums.length == 0)
			return null;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(result, list, nums, 0);
		return result;
	}
	public static void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int index){
		result.add(new ArrayList<Integer>(list));
		for(int i = index; i < nums.length; i++){
//			if( i != index && nums[i] == nums[i-1])
//				continue;
			list.add(nums[i]);
			helper(result, list, nums, i+1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
    	ArrayList<ArrayList<Integer>> result = subsets(nums);
    	System.out.println(result.toString());

    	
	}
}
