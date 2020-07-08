package leetcode651_700;

/**
 * Created by yesongren on 2020/7/9
 * 674. Longest Continuous Increasing Subsequence
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // 初始化为1，因为每个数字是最小的递增子序列
        int res = 1;
        // f[i]: 以nums[i]为结尾的最长连续上升子序列长度
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            // option 1: 只有一个数字，本身就是，长度为1
            f[i] = 1;
            // option 2: 满足nums[i]前面至少有一个数字，并且满足单调性
            if (i > 0 && nums[i - 1] < nums[i]) f[i] = f[i - 1] + 1;
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
