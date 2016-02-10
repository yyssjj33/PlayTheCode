package array;

import java.util.ArrayList;

public class Subsets {
	public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        return subsets(nums, 0);
    }
    
    private static ArrayList<ArrayList<Integer>> subsets(int[] nums, int index){
        ArrayList<ArrayList<Integer>> allSubsets;
        if (nums.length == index){
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        }else{
            allSubsets = subsets(nums, index+1);
            int item = nums[index];
            ArrayList<ArrayList<Integer>> moreSubsets = 
            new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                
                if(newSubset.size()!=0){
                	if(item == newSubset.get(newSubset.size()-1)){
                		continue;
                	}else{
                		newSubset.add(0,item);                		
                	}
                }else{
                	newSubset.add(0,item);
                	
                }
                
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
        
    }
    public static void main(String[] args) {
    	int[] nums = {1,2,2};
    	ArrayList<ArrayList<Integer>> result = subsets(nums);
    	System.out.println(result.toString());
	}
}
