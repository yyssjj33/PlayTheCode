package array;

public class LongestPalindromeInString {
	public static String longestPalindrome(String s){
        int lStart = 0;
        int lEnd = 0;

        char[] str = s.toCharArray();
        if (str.length == 0) return "";
        for (int i = 0; i < str.length; i++){
            int left = i;
            int right = i;
            while(left >= 0 && right < str.length&&str[left] == str[right]){
               
                    if (right - left > lEnd - lStart){
                        lStart = left;
                        lEnd = right;
                    }
                  
                
                left--;
                right++;
            }
            
            left = i;
            right = i + 1;
            while(left >= 0 && right < str.length&&str[left] == str[right]){
               
                    if (right - left > lEnd - lStart){
                        lStart = left;
                        lEnd = right;
                    
                   
                }
                left--;
                right++;
            }
            
        }
        return s.substring(lStart, lEnd+1);
    }
	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaba"));
	}
}
