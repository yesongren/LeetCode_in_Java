package leetcode001_050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yesongren on 2018/11/19
 */
public class ThreeSum {
    /**
     * #015 Three Sum
     *
     * Description:
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     * The solution set must not contain duplicate triplets.
     *
     * Example:
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     * A solution set is:
     *
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            int a = nums[index];
            if (index >= 1 && nums[index - 1] == a) {
                continue;
            }
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int total = a + b + c;
                if (total < 0) {
                    left++;
                } else if (total > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(a, b, c));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
