package leetcode201_250;

/**
 * Created by yesongren on 2021/2/2
 * 209. Minimum Size Subarray Sum
 * Two pointers
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int left = -1, right = 0, n = nums.length, sum = 0, res = Integer.MAX_VALUE;
        for (right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min(res, right - left);
                left++;
                sum -= nums[left];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
