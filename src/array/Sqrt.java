package array;

public class Sqrt {
	public static double sqrt(double a){
		if (a < 0) return -1;
		if (a == 0 || a == 1) return a;
		double precision = 0.000001;
		double start = 0;
		double end = a;
		if (a < 1){
			end = 1;
		}
		while (end - start > precision){
			double mid = (start + end)/2;
			double midSqr = mid * mid;
			if (midSqr == a){
				return mid;
			}
			else if(midSqr > a){
				end = mid;
			}else
				start = mid;
		}
		
		return (end + start)/2;
	}
	public static void main(String[] args) {
		System.out.println(sqrt(0.3));
	}
}
