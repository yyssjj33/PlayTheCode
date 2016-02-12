package array;

//Print all pairs in a sorted array that sum to M

public class PrintAllPairs {
	public static void print(int[] arr, int M){
		int start = 0;
		int end = arr.length - 1;
		while(start < end){
			if(arr[start] + arr[end] == M){
				System.out.println("["+arr[start]+", "+arr[end]+"]");
				start++;
				end--;
			}else if (arr[start] + arr[end] < M){
				start++;
			}else{
				end--;
			}
		}
		
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		print(arr,18);
	}
}
