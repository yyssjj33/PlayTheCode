package string;

import java.util.Arrays;

public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len1 = s1.length;
        int len2 = s2.length;
        int i = 0, j = 0;
        while(i < len1 && j < len2){
            if (Integer.parseInt(s1[i]) == Integer.parseInt(s2[j])){
                i++;
                j++;
                continue;
            }
            else if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[j])){
                return -1;
            }
            else
                return 1;
        }
        if (len1 > len2)
            return 1;
        else if (len1 < len2)
            return -1;
        else
            return 0;
    }
	
	public static void main(String[] args) {
		System.out.println(compareVersion("1.1.1","1.1"));

	}
	
}
