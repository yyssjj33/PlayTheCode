package math;

public class DivisionWithoutDivide {
	public static int divideNaive(int i, int j){
		int res = 0;
		while(i >= j){
			i -= j;
			res++;
		}
		return res;
	}
	public static int divideOpt(int i, int j){
		int res = 0;
		int base = 1;
		int cur = j;
		while(i>=j){
			if (i >= cur){
				i -= cur;
				res += base;
				base *= 2;
				cur *= 2;
			}else{
				base /= 2;
				cur /= 2;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(divideOpt(-1006986286,
				-2145851451));
	}
}
