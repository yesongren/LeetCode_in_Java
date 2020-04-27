package leetcode501_550;

/**
 * Created by yesongren on 2020/4/28
 * 509. Fibonacci Number
 */
public class FibonacciNumber {

    // 含有备忘录的递归解法（自上而下）
    public int fibRec(int N) {
        if (N < 1) return N;
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    private int helper(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }


    // 动态规划（自下而上）
    public int fibDP(int N) {
        int[] dp = new int[N + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i + 1];
        }
        return dp[N];
    }


    // 继续优化空间复杂度成 O(1)
    public int fibOpt(int N) {
        if (N == 1 || N == 2) return 1;
        int prev_1 = 1, prev_2 = 1;
        for (int i = 3; i <= N; i++) {
            int sum = prev_2 + prev_1;
            prev_2 = prev_1;
            prev_1 = sum;
        }
        return prev_1;
    }
}
