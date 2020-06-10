package leetcode351_400;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yesongren on 2020/5/17
 * 354. Russian Doll Envelopes
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        int n = A.length;
        Arrays.sort(A, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] f = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j][0] < A[i][0] && A[j][1] < A[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
