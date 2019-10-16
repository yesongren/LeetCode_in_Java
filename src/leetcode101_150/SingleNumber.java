package leetcode101_150;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yesongren on 2019/10/16
 * LeetCode #136. Single Number
 */
public class SingleNumber {
    /**
     * Time: O(n^2)
     */
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int count = countLetter(nums, nums[i]);
            if (count == 1) return nums[i];
        }
        return -1;
    }
    public int countLetter(int[] nums, int k) {
        int count= 0;
        for (int num : nums) {
            if (num == k) count++;
        }
        return count;
    }

/****************** Set method *****************/
    public int singleNumberSet(int[] nums) {
        int single = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                single = single - nums[i];
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
                single = single + nums[i];
            }
        }
        return single;
    }

/****************** XOR method *****************/
    public int singleNumberXOR(int[] nums) {
        int k = nums[0];
        for (int i = 1; i < nums.length; i++) {
            k = (k ^ nums[i]);
        }
        return k;
    }

/****************** Main Test *****************/
    public static void main(String[] args) {
        int[] arr = {5,6,6,5,8,7,7};
        SingleNumber obj = new SingleNumber();
        int ans = obj.singleNumberSet(arr);
        System.out.println(ans);
    }
}
