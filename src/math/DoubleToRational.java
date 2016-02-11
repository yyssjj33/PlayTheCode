package math;

public class DoubleToRational {
	public static String DTR(double num){
		int fenmu = 1;
		int fenzi = 1;
		while (num - (int) num >0.0000001){
			num *= 10;
			fenmu *= 10;
		}
		fenzi = (int)num;
		int divisor = gcd(fenmu, fenzi);
		fenzi /= divisor;
		fenmu /= divisor;
		
		return fenzi + "/" + fenmu;
	
		
	}
	
	private static int gcd(int a, int b){
		if (b == 0)
			return a;
		return gcd(b, a%b);
	}
	public static void main(String[] args) {
		System.out.println(0.342*10);
	}
}
