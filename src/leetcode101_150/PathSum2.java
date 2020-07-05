package leetcode101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/7/6
 * 113. Path Sum II
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> elem = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, sum, res, elem);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> elem) {
        if (root == null) return;
        elem.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) res.add(new ArrayList<>(elem));
        pathSum(root.left, sum - root.val, res, elem);
        pathSum(root.right, sum - root.val, res, elem);
        elem.remove(elem.size() - 1);
    }
}
