package array;

//Example 1:
//coins = [1, 2, 5], amount = 11
//return 3 (11 = 5 + 5 + 1)
//
//Example 2:
//coins = [2], amount = 3
//return -1.
public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount < 0) {
			return 0;
		}
		int[] opt = new int[amount + 1];

		for (int i = 1; i < opt.length; i++) {
			opt[i] = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (coin <= i && opt[i - coin] != -1) {
					opt[i] = Math.min(opt[i], 1 + opt[i - coin]);
				}
			}
			if (opt[i] == Integer.MAX_VALUE)
				opt[i] = -1;

		}

		return opt[amount];

	}

	public static void main(String[] args) {
		int[] coins = { 1, 5, 10, 20, 50, 100 };
		for (int i = 0; i < 101; i++)
			System.out.println("For " + i + " yuan, we need: " + coinChange(coins, i));
	}
}
