package string;

public class ReverseStringWord {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] splited = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = splited.length - 1; i >= 0; i--){
            if (!splited[i].equals(""))
                sb.append(splited[i].trim()+" ");
        }

        return sb.toString().trim();
    }
    public static void main(String[] args) {
    	System.out.println(reverseWords("   a   b "));
    	
	}
    
}
