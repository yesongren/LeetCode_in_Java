package leetcode051_100;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxEndHere = 0;
        int maxSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            maxEndHere += nums[i];
            if (maxEndHere < 0) {
                maxEndHere = 0;
            }
            if (maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere;
            }
        }
        return maxSoFar;
    }

}
