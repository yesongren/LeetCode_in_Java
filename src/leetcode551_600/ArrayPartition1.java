package leetcode551_600;

import java.util.Arrays;

/**
 * Created by yesongren on 2021/2/16
 * 561. Array Partition I
 */
public class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
