package leetcode301_350;

/**
 * Created by yesongren on 2020/6/5
 * 322. Coin Change
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        int i, j;
        f[0] = 0;
        for (i = 1; i <= amount; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (j = 0; j < n; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE && f[i - coins[j]] + 1 < f[i]) {
                    f[i] = f[i - coins[j]] + 1;
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) return -1;
        else return f[amount];
    }
}
