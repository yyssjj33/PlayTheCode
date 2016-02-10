package array;

import java.util.HashSet;
import java.util.TreeSet;

public class FindAllPalindromeInString {
	public static TreeSet<String > find(String s){
		int len = s.length();
		TreeSet<String> res = new TreeSet<String>();
        boolean[][] palindrome = new boolean[len][len];
        if (len < 1) {
        	System.out.println();
        	return null;
        }

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
        
        for(int i = 0; i < len; i++){
        	for(int j = i; j < len; j++){
        		if(palindrome[i][j]){
        			res.add(s.substring(i,j+1));
        		}
        	}
        }
        return res;
	}
	public static void main(String[] args) {
		String s = "abaaa";
		StringBuilder a = new StringBuilder("asdad");
		StringBuffer b = new StringBuffer("adsdas");

		TreeSet<String> res=find(s);
		System.out.println(res.toString());
	}
}
