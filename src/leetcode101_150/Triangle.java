package leetcode101_150;

import java.util.List;

/**
 * Created by yesongren on 2020/7/14
 * 120. Triangle
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int[][] f = new int[n][n];
        f[0][0] = t.get(0).get(0);
        int i, j;
        for (i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + t.get(i).get(0);
            f[i][i] = f[i - 1][i - 1] + t.get(i).get(i);
            for (j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + t.get(i).get(j);
            }
        }

        int res = f[n - 1][0];
        for (i = 0; i < n; i++) {
            res = Math.min(res, f[n - 1][i]);
        }
        return res;
    }
}
