package leetcode101_150;

/**
 * Created by yesongren on 2020/6/10
 * 122. Best Time to Buy and Sell Stock II
 *
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}
