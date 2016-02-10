package array;

public class IsItPossible {
	
	static String isitpossible(int a, int b, int c, int d) {
        
		   
//        if (a+b >= d && a+b >= c || a*d == c*b)
//            return "No";
        if (gcd(a,b) == gcd(c,d))
            return "Yes";
        else
            return "No";

    }
	static String isitpossible2(int a, int b, int c, int d) {
		if (helper(a,b,c,d))
			return "Yes";
		else return "No";
	}
	
	static boolean helper(int a, int b, int c, int d){
		if (a>c || b>d)
			return false;
		if (a==c && b==d)
			return true;
		return helper(a+b,b,c,d)||helper(a,b+a,c,d);

	}
//    static int gcd(int a, int b){
//        if (b == 0)
//            return a;
//        else
//            return gcd(b, a % b);
//
//    }
//    static String isitpossible(int a, int b, int c, int d) {
//        
//    	   
//        if (a+b >= d && a+b >= c || a*d == c*b)
//            return "No";
//        if (gcd(a,b) == gcd(c,d))
//            return "Yes";
//        else
//            return "No";
//
//    }

    static int gcd(int a, int b){
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);

    }


    
    public static void main(String[] args) {
    	
		System.out.println(isitpossible2(1,4,5,9));

	}
}
