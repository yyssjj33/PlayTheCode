package array;

public class BinarySearch {
	public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;//last position
            	//end = mid; //first position
                //return mid; //just one
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] {1,2,3,3,3,3,4,5,6,7,8},3));
	}
}
