package leetcode351_400;

/**
 * Created by yesongren on 2020/7/5
 * 377. Combination Sum IV
 */
public class CombinationSum4 {
    public int combinationSum4(int[] A, int T) {
        int n = A.length;
        int[] f = new int[T + 1];
        int i, j;
        f[0] = 1;
        for (i = 1; i <= T; i++) {
            f[i] = 0;
            for (j = 0; j < n; j++) {
                if (i >= A[j]) f[i] += f[i - A[j]];
            }
        }
        return f[T];
    }
}
