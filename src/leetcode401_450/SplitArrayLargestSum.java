package leetcode401_450;

/**
 * Created by yesongren on 2020/7/25
 * 410. Split Array Largest Sum
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = counter(nums, mid);
            if (cnt > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int counter(int[] nums, int maxSum) {
        int cnt = 1;
        int tsum = 0;
        for (int num : nums) {
            if (tsum + num > maxSum) {
                tsum = num;
                cnt++;
            } else {
                tsum += num;
            }
        }
        return cnt;
    }
}
