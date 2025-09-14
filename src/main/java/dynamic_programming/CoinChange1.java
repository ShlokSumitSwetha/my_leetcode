package dynamic_programming;

public class CoinChange1 {

	public static void main(String[] args) {

		int[] nums= {1,2,5};

		System.out.println(coinChange(nums, 11));
	}

	public static int coinChange(int[] coins, int amount) {

		if (amount < 1) {
			return 0;
		}
		int[] minCoins = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			minCoins[i] = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (coin <= i && minCoins[i - coin] != Integer.MAX_VALUE) {
					//  1+ f(previous function value)
					minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
				}
			}
			if (minCoins[amount] == Integer.MAX_VALUE) {
				return -1;
			}
		}
		return minCoins[amount];

	}
}
