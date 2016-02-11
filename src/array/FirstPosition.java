package array;

public class FirstPosition {
	public static int binarySearch(int[] nums, int target) {
        //write your code here
        int start = 0;
        int end = nums.length - 1;
        if(end == -1) return -1;
        int mid = 0;
//        while(start <= end){
//            mid = start+(end - start)/2;
//            if (nums[mid] == target && (mid > 0 && nums[mid-1] < nums[mid] || mid == 0))
//                return mid;
//            if (nums[mid] == target && (mid > 0 && nums[mid-1]==nums[mid]) || nums[mid] > target)
//            	end = mid-1;
//            if (nums[mid] < target)
//            	start = mid + 1;
//        }
        while (start + 1 < end){
        	mid = (start + end) / 2;
        	if(nums[mid] < target){
        		start = mid;
        	}else{
        		end = mid;
        	}
        }
        if (start == end){
            if (target == nums[start])
                return start;
            return -1;
        }
            
        if (target == nums[start])
            return start;
        else if (target == nums[end])
            return end;
        return -1;
    }

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 5, 10 };
		System.out.println(binarySearch(nums, 6));
	}
}
