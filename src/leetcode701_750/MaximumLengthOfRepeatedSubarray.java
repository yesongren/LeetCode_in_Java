package leetcode701_750;

/**
 * Created by yesongren on 2020/10/14
 * 718. Maximum Length of Repeated Subarray
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] f = new int[m + 1][n + 1]; // A的前i项与B的前j项的最长重复子数组长度
        int ans = 0;
        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    ans = Math.max(ans, f[i][j]);
                }
            }
        }
        return ans;
    }
}
