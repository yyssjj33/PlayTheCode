package string;

import java.security.DigestInputStream;

public class BinaryAdd {
	public static String addBinary(String as, String bs) {
        // Write your code here
        int lenA = as.length();
        int lenB = bs.length();
        int len = Math.max(lenA, lenB);
        StringBuffer a = new StringBuffer(as);
        StringBuffer b = new StringBuffer(bs);
        a=a.reverse();
        b=b.reverse();
        if(lenA>lenB){
            int off = lenA-lenB;
            for(int i = 0; i < off; i++)
                b.append('0');
        }
        if(lenA<lenB){
            int off = lenB-lenA;
            for(int i = 0; i < off; i++)
                a.append('0');
        }
        
        char carry = '0';
        
        StringBuffer result = new StringBuffer(); 
      
        for(int i = 0; i < len; i++){
            if((a.charAt(i)-'0')+(b.charAt(i)-'0')==1){
                if(carry == '0'){

                }
                if(carry == '1'){
                    result.append('0');
                }
            }
            if(a.charAt(i)=='0'&&b.charAt(i)=='0'){
                if(carry == '0'){
                    result.append('0');
                }
                if(carry == '1'){
                    result.append('1');
                    carry = '0';
                }
            }
            if(a.charAt(i)=='1'&&b.charAt(i)=='1'){
            	if(carry == '1'){
                    result.append('1');
                }
                if(carry == '0'){
                    result.append('0');
                    carry = '1';
                }
                
            }
        }
        
        if(carry == '1') result.append(carry);
        return result.reverse().toString();
    }
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));
	}
}
