package leetcode251_300;

/**
 * Created by yesongren on 2021/1/13
 * 276. Paint Fence
 */
public class PaintFence {
    public int numWaysDP1(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1 && k >= 1) return k;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = k;
        f[2] = k * k;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 2] * (k - 1) + f[i - 1] * (k - 1);
        }
        return f[n];
    }

    public int numWaysDP2(int n, int k) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i ++){
            if(i == 1){
                dp[i] = k;
            }else if(i == 2){
                dp[i] = k * k;
            }else{
                dp[i] = dp[i - 2] * (k - 1) + dp[i - 1] * (k - 1);
            }
        }
        return dp[n];
    }
}
