package leetcode101_150;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yesongren on 2019/11/14
 * #137. Single Number 2
 */
public class SingleNumber2 {

    //HashMap 计数
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }
        int res = 0;
        for (Integer count : map.keySet()) {
            if (map.get(count) == 1) {
                res = count;
            }
        }
        return res;
    }

    // bit manipulation 1
    public int singleNumber2(int[] nums) {
        //if (nums.length == 1) return nums[0];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) sum++;
            }
            sum %= 3;
            res = res | sum << i;
        }
        return res;
    }


    public static void main(String[] args) {
        SingleNumber2 obj = new SingleNumber2();
        int nums[] = {5,5,5,7};
        System.out.println(obj.singleNumber2(nums));
    }
}
