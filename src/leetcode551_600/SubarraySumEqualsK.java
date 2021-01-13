package leetcode551_600;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2021/1/13
 * 560. Subarray Sum Equals K
 */
public class SubarraySumEqualsK {
    public int subarraySumPrefix(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, cnt = 0;
        for (int num : nums) {
            sum += num;
            cnt += map.getOrDefault(sum - k, 0);
            int sumCnt = map.getOrDefault(sum, 0);
            map.put(sum, sumCnt + 1);
        }
        return cnt;
    }

    public int bruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int cnt = 0;
        for (int left = 0; left < n; left++) {
            int sum = 0;
            for (int right = left; right < n; right++) {
                sum += nums[right];
                if (sum == k) cnt++;
            }
        }
        return cnt;
    }
}
