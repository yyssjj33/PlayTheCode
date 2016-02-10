package string;

import java.util.Stack;

public class Calculator {
	 public int calculate(String s) {
	        Stack<Character> ops = new Stack<Character>();
	        Stack<Integer> nums = new Stack<Integer>();
	        s = clean(s);
	        int i = 0;
	        while (i < s.length()){
	            char c = s.charAt(i);
	            if (Character.isDigit(c)){
	                int temp = c-'0';
	                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
	                    temp = temp*10 + s.charAt(i+1) - '0';
	                    i++;
	                }
	                nums.push(temp);
	                i++;
	            }
	            
	            if (c == '+' || c == '-'){
	                ops.push(c);
	                i++;
	            }
	            if (c == '('){
	                i++;
	                continue;
	            }
	            if (c == ')'){
	            	if (ops.isEmpty()){i++; continue;}
	                char op = ops.pop();
	                if (op == '+'){
	                    int num1 = nums.pop();
	                    int num2 = nums.pop();
	                    nums.push(num1+num2);
	                }
	                if (op == '-'){
	                    int num1 = nums.pop();
	                    int num2 = nums.pop();
	                    nums.push(num2-num1);
	                }
	                i++;
	                
	            }
	            
	        }
	        while (!ops.isEmpty()){
	            char op = ops.pop();
	            if (op == '+'){
	                    int num1 = nums.pop();
	                    int num2 = nums.pop();
	                    nums.push(num1+num2);
	                }
	            if (op == '-'){
	                    int num1 = nums.pop();
	                    int num2 = nums.pop();
	                    nums.push(num2-num1);
	                }
	        }
	        return nums.pop();
	    }
	    private String clean(String s){
	        StringBuffer result = new StringBuffer();
	        for (int i = 0; i < s.length(); i++){
	            if(s.charAt(i)!=' ')
	                result.append(s.charAt(i));
	        }
	        return result.toString();
	    }
	    public static void main(String[] args) {
			Calculator cal = new Calculator();
			String s = " 2-1 + 2 ";
			int res = cal.calculate(s);
			System.out.println(res);
		}
}
