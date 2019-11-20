package leetcode001_050;

import java.util.Arrays;

/**
 * Created by yesongren on 2019/11/20
 * #016. 3Sum Closest
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        //错的，如果target的值非常接近MAX，那么就是错的
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            int a = nums[index];
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int total = a + b + c;
                if (total == target) return target;
                if (Math.abs(total - target) < Math.abs(res - target)) res = total;
                if (total < target) left++;
                if (total > target) right--;
            }
        }
        return res;
    }

    public int threeSumClosest2(int[] nums, int target) {

        int res = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            int a = nums[index];
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int total = a + b + c;
                if (total == target) return target;
                if (Math.abs(total - target) < diff) {
                    res = total;
                    diff = Math.abs(total - target);
                }
                if (total < target) left++;
                if (total > target) right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest obj = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, 4};
        int res = obj.threeSumClosest(nums, 1);
        System.out.println(res);
    }
}
