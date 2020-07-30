package leetcode301_350;

/**
 * Created by yesongren on 2020/7/31
 * 343. Integer Break
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] f = new int[n + 1];
        f[2] = 1;
        int i, j;
        for (i = 0; i <= n; i++) {
            for (j = 1; j < i; j++) {
                f[i] = Math.max(f[i], Math.max(j * (i - j), f[i - j] * j));
            }
        }
        return f[n];
    }
}
