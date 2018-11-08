package leetcode001_050;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /** #001 Two Sum
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * 用key装值，用value装index
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {-1, -1};
        }
        int[] result = new int[] {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {0,2,4,6,7,11};
        TwoSum twoSum = new TwoSum();
        //System.out.println(twoSum.twoSum(array, 13));    //这样输出的是数组的地址
        System.out.println(Arrays.toString(twoSum.twoSum(array, 17)));
    }
}
