package leetcode601_650;

import java.util.Arrays;

/**
 * Created by yesongren on 2021/1/21
 * 628. Maximum Product of Three Numbers
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int A = nums[0] * nums[1] * nums[n - 1];
        int B = nums[n - 1] * nums[n - 2] *nums[n - 3];
        return Math.max(A, B);
    }
}
