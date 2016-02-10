package array;

public class FindInRotateSortedArray {
	public static int search(int[] A, int target) {
        // write your code here
        
		int start = 0;
        int end = A.length-1;
        if(end == -1) return -1;
        int last = A[end];
        int mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(A[mid] == target)
                return mid;
            if(A[start]<=A[mid]){
                if(A[mid]>target && target >= A[start])
                    end = mid-1;
                else
                    start = mid+1;
            }else{
                if(A[mid]<target && target<=A[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		int[] A = {0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
		System.out.println(search(A,-9));
	}
}
