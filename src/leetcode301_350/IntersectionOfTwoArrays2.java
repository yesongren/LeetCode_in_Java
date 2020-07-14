package leetcode301_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yesongren on 2020/7/14
 * 350. Intersection of Two Arrays II
 */
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums1) {
            int cnt = counter.getOrDefault(num, 0);
            counter.put(num, cnt + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            int cnt = counter.getOrDefault(num, 0);
            if (cnt > 0) {
                list.add(num);
                counter.put(num, cnt - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
