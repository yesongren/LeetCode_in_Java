package leetcode001_050;

/**
 * Created by yesongren on 2020/7/8
 * 45. Jump Game II
 */
public class JumpGame2 {
    /**
     * dp, TLE
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[] f = new int[n];
        f[0] = 0;
        int i, j;
        for (i = 1; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (A[j] + j >= i) f[i] = Math.min(f[i], f[j] + 1);
            }
        }
        return f[n - 1];
    }

    /**
     * Greedy, AC
     */
    public int jumpGreedy(int[] A) {
        int n = A.length - 1;
        int cnt = 0;
        int reachable = 0;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            reachable = Math.max(reachable, A[i] + i);
            if (i == pos) {
                pos = reachable;
                cnt++;
            }
        }
        return cnt;
    }
}
