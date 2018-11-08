package leetcode001_050;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /** #001
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * 用key装值，用value装index
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[] {-1, -1};
        int[] res = new int[] {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(Math.min(target - numbers[i], i));
                res[1] = map.get(Math.max(target - numbers[i], i));
            }
            map.put(numbers[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {0,2,4,6,7,13};
        TwoSum twoSum = new TwoSum();
        //System.out.println(twoSum.twoSum(array, 13));    //这样输出的是数组的地址
        System.out.println(Arrays.toString(twoSum.twoSum(array, 13)));
    }
}
