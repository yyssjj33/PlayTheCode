package array;

import java.util.Arrays;

public class PalindromePartitionII {
    public static int minCut(String s) {
        int len = s.length();
        boolean[][] palindrome = new boolean[len][len];
        if (len <= 1) {return 0;}

        for(int i = 0; i < len; i++){
            palindrome[i][i] = true;
        }
        
        for(int i = 1; i < len; i++){
            if (s.charAt(i)==s.charAt(i-1)){
                palindrome[i-1][i] = true;
            }
        }
        
        for(int i = 2; i < len; i++){
            for (int j = 0; j < len-i; j++){
                palindrome[j][i+j] = (s.charAt(j)==s.charAt(i+j)&&palindrome[j+1][i+j-1]);
            }
        }
        
        int cut[] = new int[len];
        
        for (int i = 0; i < len; i++){
        	if (palindrome[0][i])
        		cut[i]=0;
        	else{
        		int temp = Integer.MAX_VALUE;
	        	for (int j = i; j >=0; j--){
	        		if(palindrome[j][i])
	        			temp = Math.min(temp, 1+cut[j]);
	        	}
	        	cut[i] = temp;
        	}
        }
        
        return cut[len-1];
        
    }
    public static void main(String[] args) {
    	System.out.println(minCut("abababababaaba"));
 
	}
}
