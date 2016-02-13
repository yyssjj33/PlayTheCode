package string;

import java.util.HashMap;
import java.util.LinkedList;


public class InfixToPostfix {
	public static int calculate(String s) {
        s = toPostfix(clean(s)).trim();
        String[] exp = s.split(" ");
        LinkedList<Integer> ans = new LinkedList<Integer>();
        for(int i = 0; i < exp.length; i++){
            String val = exp[i].trim();
            if (val.equals("+")){
                int num1 = ans.pop();
                int num2 = ans.pop();
                ans.push(num1+num2);
            }else if (val.equals("-")){
                int num1 = ans.pop();
                int num2 = ans.pop();
                ans.push(num2-num1);
            }else if (val.equals("*")){
                int num1 = ans.pop();
                int num2 = ans.pop();
                ans.push(num1*num2);
            }else if (val.equals("/")){
                int num1 = ans.pop();
                int num2 = ans.pop();
                ans.push(num2/num1);
            }else if (val.equals("^")){
            	int num1 = ans.pop();
            	int num2 = ans.pop();
            	ans.push((int)Math.pow(num2, num1));
            }
            else{
                ans.push(Integer.valueOf(val));
            }
            
        }
        return ans.pop();
    }
	public static String toPostfix(String s){
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		StringBuffer result = new StringBuffer();
		LinkedList<Character> ops = new LinkedList<Character>();
		priority.put('+', 0);
		priority.put('-', 0);
		priority.put('*', 1);
		priority.put('/', 1);
		priority.put('^', 2);
		int i = 0;
		while(i < s.length()){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				int temp = c -'0';
				while (i+1<s.length() && Character.isDigit(s.charAt(i+1))){
					temp = temp*10 + s.charAt(i+1)-'0';
					i++;
				}
				result.append(temp).append(" ");
				i++;
			}
			if (c=='+' || c=='-' || c=='*' || c=='/' || c=='^'){
				if(ops.isEmpty()) {
					ops.push(c);
					i++;
					continue;
				}
				else{
					while(!ops.isEmpty()&&ops.peek()!='('&&priority.get(ops.peek())>=priority.get(c)){
						
						result.append(ops.pop()).append(" ");
					}
				}
				ops.push(c);
				i++;
			}
			if (c == '('){
				ops.push(c);
				i++;
			}
			if (c == ')'){
				while (ops.peek()!='('&&!ops.isEmpty()){
					result.append(ops.pop()).append(" ");
				}
				ops.pop();
				i++;
			}
		}
		while(!ops.isEmpty()){
			result.append(ops.pop()).append(" ");
		}
		
		return result.toString();
	}
    private static String clean(String s){
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i)!=' ')
                result.append(s.charAt(i));
        }
        return result.toString();
    }
    public static void main(String[] args) {
    	System.out.println(calculate("(3+2)^(3-1)-7*(1-2)"));
    	
    }
}
