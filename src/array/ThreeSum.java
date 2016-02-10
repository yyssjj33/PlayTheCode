package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	 public static List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> list;
	        Arrays.sort(nums);
	        for (int i = 0; i < nums.length; i++){
	            if (i == 0 || nums[i] != nums[i-1]){
	                int l = i + 1;
	                int r = nums.length - 1;
	                while (l < r){
	                    list = new ArrayList<Integer>();
	                    if (nums[i] + nums[l] + nums[r] == 0){
	                        list.add(nums[i]);
	                        list.add(nums[l]);
	                        list.add(nums[r]);
	                        result.add(list);
	                        while ( l < r && nums[l+1]==nums[l]){
	                            l++;
	                        }
	                        while ( l < r && nums[r-1]==nums[r]){
	                            r--;
	                        }
	                        r--;
	                        l++;
	                    }
	                    else if (nums[i] + nums[l] + nums[r] > 0)
	                        r--;
	                    else
	                        l++;
	                }
	                
	            }
	        }
	        return result;
	    }
	 public static void main(String[] args) {
		int[] l = {-1, -1, -1,-1,-1,-1,2};
		List<List<Integer>> result = threeSum(l);
		System.out.println(result.toString());
	}
}
