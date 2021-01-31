package leetcode401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2021/1/31
 * 448. Find All Numbers Disappeared in an Array
 * sort indexing
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] d = new int[n + 1];
        d[0] = 0;
        System.arraycopy(nums, 0, d, 1, n);
        for (int i = 1; i < n + 1; i++) {
            while (d[i] >= 1 && d[i] <= n && d[i] != i && d[d[i]] != d[i]) { // 这里前两个判定条件可以省略，因为题目中有限制 1 ≤ a[i] ≤ n
                swap(d, d[i], i);
            }
        }
        for (int i = 0; i < n + 1; i++) {
            if (d[i] != i) res.add(i);
        }
        return res;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
