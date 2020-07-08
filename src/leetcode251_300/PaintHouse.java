package leetcode251_300;

/**
 * Created by yesongren on 2020/7/9
 * 256. Paint House
 */
public class PaintHouse {
    public int minCost(int[][] A) {
        int n = A.length;
        if (n == 0) return 0;
        // f[i][j]: 油漆喷前i栋房子，并且第i-1栋房子是R,G,B三种颜色的最小花费
        int[][] f = new int[n + 1][3];
        f[0][0] = f[0][1] = f[0][2] = 0;
        int i, j, k, res;
        for (i = 1; i <= n; i++) {
            for (j = 0; j < 3; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (k = 0; k < 3; k++) {
                    if (j == k) continue;
                    if (f[i - 1][k] + A[i - 1][j] < f[i][j]) {
                        f[i][j] = f[i - 1][k] + A[i - 1][j];
                    }
                }
            }
        }
        res = f[n][0];
        if (res > f[n][1]) res = f[n][1];
        if (res > f[n][2]) res = f[n][2];
        return res;
    }
}
