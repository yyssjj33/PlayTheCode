package array;

import java.util.ArrayList;

public class SearchForRange {
	public static int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[2];
        int left = -1;
        int right = -1;
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        ArrayList<Integer> i = new ArrayList<Integer>();
        while (start + 1 < end){
        	mid = start + (end - start)/2;
        	if ((mid != 0 && A[mid] == target && A[mid-1] < target)|| (mid == 0 && A[mid] == target)){
        		left = mid;
        		break;
        	}
        	else if (A[mid] >= target){
        		end = mid;
        	}
        	else {
        		start  = mid;
        	}
        }
        if (A[start]==target) left = end;
        else left = start;

        start = 0;
        end = A.length - 1;
        mid = 0;
        while (start < end){
        	mid = start + (end - start)/2;
        	if ((mid != A.length - 1 && A[mid] == target && A[mid+1]>target) || (mid == A.length - 1 && A[mid] == target)){
        		right = mid;
        		break;
        	}
        	else if (A[mid] <= target){
        		start = mid;
        	}
        	else {
        		end = mid;
        	}
        }
        if (A[start]==target) left = start;
        else left = end;
        
        result[0] = left;
        result[1] = right;
        
        return result;
    }
	public static void main(String[] args) {
		int[] result;
		result = searchRange(new int[] {2,2,2,2,7,7,8,8,10,10},2);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
