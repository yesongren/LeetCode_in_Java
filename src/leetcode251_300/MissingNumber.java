package leetcode251_300;

/**
 * Created by yesongren on 2019/10/15
 * LeetCode #268. Missing Number
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {

        boolean arr[] = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            arr[i] = false;
        }

        for (int i = 0; i < nums.length; i++) {
            int id = nums[i];
            arr[id] = true;
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!arr[i]) return i;
        }
        return 0;
    }

    /******************** optimize ********************/

    public int missingNumber2(int[] nums) {
        int size = nums.length;
        int sum = size * (size + 1) / 2;
        for (int i = 0; i < size; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }
}
