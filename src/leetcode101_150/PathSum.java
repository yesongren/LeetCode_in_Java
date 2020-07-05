package leetcode101_150;

/**
 * Created by yesongren on 2020/7/3
 * 112. Path Sum
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
