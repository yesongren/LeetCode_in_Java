package leetcode051_100;

/**
 * Created by yesongren on 2020/7/6
 * 63. Unique Paths II
 */
public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] G) {
        int m = G.length, n = G[0].length;
        if (m == 0 || n == 0) return 0;
        int[][] f = new int[m][n];
        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (G[i][j] == 1) f[i][j] = 0;
                else {
                    if (i == 0 && j == 0) f[i][j] = 1;
                    else {
                        f[i][j] = 0;
                        if (i - 1 >= 0) f[i][j] += f[i - 1][j];
                        if (j - 1 >= 0) f[i][j] += f[i][j - 1];
                    }
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
