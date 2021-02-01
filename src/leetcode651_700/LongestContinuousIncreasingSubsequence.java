package leetcode651_700;

/**
 * Created by yesongren on 2020/7/9
 * 674. Longest Continuous Increasing Subsequence
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS_DP(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // 初始化为1，因为每个数字是最小的递增子序列
        int res = 1;
        // f[i]: 以nums[i]"为结尾"的最长连续上升子序列长度
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

    /**
     * Two pointers
     */
    public int findLengthOfLCIS_TwoPointers(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1, tempLen = 1; // tempLen 储存每一轮的递增序列长度
        int i = 0, j = 1, len = nums.length;
        while (j < len) {
            if (nums[i] < nums[j]) {
                tempLen++;
                res = Math.max(res, tempLen);  // res 取 max(之前所有轮中的最大值, 本轮的最大值)
                i++;
                j++;
            } else {
                i = j;  // i 直接跳到 j 处，跨过 [i, j) 中间的所有元素
                j++;
                tempLen = 1;  // 开始新一轮递增序列长度的计算，temp 需要复位为 1
            }
        }
        return res;
    }
}
