package array;

import java.util.Arrays;

public class PalindromeABCDtoABBA {
	public static int solve(String s){
		
		int len = s.length();
		if (len <= 0) return 0;
		int res = 0;
		for (int i = 0; i < len/2; i++){
			if(s.charAt(i) != s.charAt(len - i -1)){
				int diff = s.charAt(i) - s.charAt(len - i -1);
				if (diff > 0){
					res += diff;
				}else{
					res -= diff;
				}
			}
		}
		
		return res;
	}
	
	

	
	public static void main(String[] args) {
	
	
	}
}
