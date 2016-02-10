package array;
//2 sorted arrays, check if one is the subset of the other one
public class IsSubset {
	public static boolean check(int[] A, int[] B){
		int lenA = A.length;
		int lenB = B.length;
		int a=0, b=0;
		
		if (lenA > lenB) return false;
		while (a < lenA && b < lenB){
			if (A[a] == B[b]){
				a++;
				b++;
				continue;
			}else if (A[a] > B[b]){
				b++;
				continue;
			}else{
				break;
			}
		}
		
		return a == lenA;
	}
	public static void main(String[] args) {
		int[] A = {2,6};
		int[] B = {1,2,3,4,5};
		System.out.println(check(A,B));
	}
}
