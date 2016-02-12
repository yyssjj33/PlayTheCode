package array;


//Print all possible combinations of coins per change amount

public class PrintAllCoins {
	public static void print(int[] coins, int[] counts, int startIndex, int total){
		if (startIndex>=coins.length){
			for (int i = 0; i < coins.length-1; i++) {
				System.out.print(counts[i] +"*"+coins[i]+" + ");
			}
			System.out.println(counts[coins.length-1] +"*"+coins[coins.length-1]+" = "+ total);
		}
		
		if (startIndex == coins.length-1){
			if (total%coins[startIndex] == 0){
				counts[startIndex] = total/coins[startIndex];
				print(coins,counts,startIndex+1,0);
			}
		}else{
			for (int i = 0; i <= total/coins[startIndex]; i++){
				counts[startIndex] = i;
				print(coins, counts, startIndex+1, total-coins[startIndex]*i);
			}
		}
	}
}
