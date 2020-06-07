package leetcode051_100;

/**
 * Created by yesongren on 2020/6/8
 * 64. Minimum Path Sum
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) f[i][j] = grid[i][j];
                else if (i == 0) f[i][j] = f[i][j - 1] + grid[i][j];
                else if (j == 0) f[i][j] = f[i - 1][j] + grid[i][j];
                else f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
