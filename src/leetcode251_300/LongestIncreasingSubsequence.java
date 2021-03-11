package leetcode251_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2021/3/11
 * 300. Longest Increasing Subsequence
 * DP
 * Binary Search & Greedy
 */
public class LongestIncreasingSubsequence {
    /**
     * Binary Search & Greedy
     */
    public int lengthOfLIS_BinarySearch(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            int left = 0, right = arr.size();
            int pos = lower_bound(arr, left, right, num);
            if (pos == arr.size()) arr.add(num);
            else arr.set(pos, num);
        }
        return arr.size();
    }

    public int lower_bound(List<Integer> arr, int left, int right, int tar) {
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (arr.get(mid) < tar) left = mid + 1;
            else right = mid;
        }
        return left;
    }


    /**
     * DP
     */
    public int lengthOfLIS_DP(int[] nums) {
        int n = nums.length, res = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i] && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                }
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
