package leetcode601_650;

/**
 * Created by yesongren on 2021/2/4
 * 643. Maximum Average Subarray I
 */
public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double t = sum;
        for (int i = 1; i < n - k + 1; i++) {
            t = t - nums[i - 1] + nums[i + k - 1];
            sum = Math.max(sum, t);
        }
        return sum / k;
    }
}
