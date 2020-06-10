package leetcode251_300;

/**
 * Created by yesongren on 2020/6/11
 * 279. Perfect Squares
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (f[i - j * j] + 1 < f[i]) {
                    f[i] = f[i - j * j] + 1;
                }
            }
        }
        return f[n];
    }
}
