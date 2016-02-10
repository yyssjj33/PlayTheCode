package array;

import java.util.Arrays;

public class JumpGameII {
	public static int[] jump(int[] A) {
        // write your code here
        int len = A.length;
        int opt[] = new int[len];
        opt[0] = 0;

        for (int i = 1; i < len; i++){
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++){
                if (A[j]+j >= i){
                    temp=Math.min(temp,opt[j]+1);
                }
            }
            opt[i] = temp;
        }
        return opt;
    }
	public static void main(String[] args) {
			int[] A = {5,8,7,3,4,5,7,9,5,43,2,9,0,4,5,7,2,3,4,5,7,4,3,7,5,0,7,9,8,2,3,7,8,9,2,5,8,4,5,1,1,3,9};
			int[] B = {2,4,1,1,1,0,6};
			int[] opt = jump(B);
			System.out.println(Arrays.toString(opt));
	}
	
}
