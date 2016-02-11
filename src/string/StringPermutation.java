package string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
	public static List<String> permutation(String s){
		List<String> res = new ArrayList<String>();
		char[] str = s.toCharArray();
		permutation(str, 0, res);
		return res;
	}
	
	private static void permutation(char[] s, int cur, List<String> res){
		if (cur == s.length-1){
			res.add(new String(s));
			return;
		}
		permutation(s, cur+1, res);
		for (int i = cur+1; i < s.length; i++){
			char temp = s[cur];
			s[cur] = s[i];
			s[i] = temp;
			permutation(s, cur+1, res);
		}
	}
	
	public static void main(String[] args) {
		List<String> res = new ArrayList<String>();
		res = permutation("abcd");
		System.out.println(res);
		
	}
}
