package leetcode051_100;

import java.util.Arrays;

/**
 * Created by yesongren on 2020/11/24
 * 56. Merge Intervals
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, (v1 , v2) -> v1[0] - v2[0]);
        int index = -1;
        for (int[] in : intervals) {
            if (index == -1 || in[0] > res[index][1]) {
                res[++index] = in;
            } else {
                res[index][1] = Math.max(res[index][1], in[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }
}
