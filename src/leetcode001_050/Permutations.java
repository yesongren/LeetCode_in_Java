package leetcode001_050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yesongren on 2020/4/17
 * 46. Permutations
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        helper(list, res, 0);
        return res;
    }

    private void helper(List<Integer> cur, List<List<Integer>> res, int start) {
        if (start == cur.size()) res.add(new ArrayList<>(cur));
        else for (int i = start; i < cur.size(); i++) {
            Collections.swap(cur, i, start);
            helper(cur, res, start + 1);
            Collections.swap(cur, i, start);
        }
    }
}
