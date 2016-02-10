package array;

public class MinRotateSortedArray {
	public static int findMin(int[] num) {
        // write your code here
        if(num.length == 1) return num[0];
        int start = 0;
        int end = num.length-1;
        int mid = 0;
        int last = num[end];
        while(start <= end){
            mid = (start + end)/2;
            if (mid>0&&mid<num.length&&num[mid]<num[mid+1]&&num[mid]<num[mid-1])
                break;
            if (num[mid]<num[mid+1] && num[mid] > last)
                start = mid + 1;
            if (num[mid]<num[mid+1] && num[mid] < last)
                end = mid - 1;
            if (num[mid]>num[mid+1]){
            	mid = mid+1;
            	break;
            }
        }
        StringBuffer s = new StringBuffer();

       
        return num[mid];
    }
	public static void main(String[] args) {
		int[] num = {6,1,2,3,4,5};
		System.out.println(findMin(num));
	}
}
