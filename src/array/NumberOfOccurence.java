package array;

// count occurence of target in a sorted array
public class NumberOfOccurence {
	public static int count(int[] nums, int target){
		return count(nums,target, 0, nums.length-1);
	}
	public static int count(int[] nums, int target, int start, int end){
		if(end < start)
			return 0;
		if(nums[start] > target)
			return 0;
		if(nums[end] < target)
			return 0;
		if(nums[start]==target&&nums[end]==target)
			return end-start+1;
		
		int mid = (start+end)/2;
		if (nums[mid] == target){
			return 1+count(nums, target, start,mid-1)+count(nums,target,mid+1,end);
		}else if(nums[mid] < target){
			return count(nums,target,mid+1,end);
		}else{
			return count(nums, target, start,mid-1);
		}
		
	}
	public static void main(String[] args) {
		int[] nums = {2,2,2,2,3,3,3};
		System.out.println(count(nums,2));
	}
}
