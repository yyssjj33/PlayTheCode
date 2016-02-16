package string;

import java.util.Arrays;

public class LongestSubstringWithoutRepeat {
	public static int longest(String s){
		
		int[] table = new int[256];
		Arrays.fill(table, -1);
		int maxLen = 0;
		int prev = 0;
		for (int i = 0; i < s.length(); i++){
			
			if (table[s.charAt(i)] >= prev){
				prev = table[s.charAt(i)]+1;
			}
			table[s.charAt(i)] = i;
			maxLen = Math.max(maxLen, i - prev + 1);
			
		}
	
		return maxLen;
	}
}
