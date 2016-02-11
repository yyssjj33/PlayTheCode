package string;
//https://leetcode.com/problems/generate-parentheses/
public class PrintParenthesis {
	public static void print(int leftRemain, int rightRemain){
		print("",leftRemain,rightRemain);
	}
	public static void print(String p, int leftRemain, int rightRemain){
		if (rightRemain == 0){
			System.out.println(p);
			return;
		}
		
		if (leftRemain > 0){
			print(p+"(", leftRemain-1, rightRemain);
			if (leftRemain < rightRemain)
				print(p+")", leftRemain, rightRemain-1);
		}else{
			print(p+")", leftRemain, rightRemain-1);
		}
		
	}
	public static void main(String[] args) {
		print(4,4);
	}
}
