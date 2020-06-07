package leetcode051_100;

/**
 * Created by yesongren on 2020/6/6
 * 62. Unique Paths
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        // init
        f[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) f[i][j] = 1;
                else f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
