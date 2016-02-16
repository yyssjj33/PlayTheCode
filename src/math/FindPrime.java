package math;

import java.util.ArrayList;

public class FindPrime {
	public static ArrayList<Integer> find(int n){
		ArrayList<Integer> res = new ArrayList<Integer>();
		boolean isPrime[] = new boolean[n+1];
		for (int i = 0; i < isPrime.length; i++)
			isPrime[i] = true;
		for(int i = 2; i <= n/i; i++){
			if(isPrime[i]){
				for (int j = i; j <= n/i; j++){
					isPrime[j*i] = false;
				}
			}
		}
		for(int i = 2; i < isPrime.length; i++){
			if (isPrime[i])
				res.add(i);
		}
		return res;
 	}
	public static void main(String[] args) {
		System.out.println(find(10));
	}
}
