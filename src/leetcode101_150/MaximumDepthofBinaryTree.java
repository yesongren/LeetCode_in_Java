package leetcode101_150;

/**
 * Created by yesongren on 2019/10/14
 * LeetCode #104: Maximum Depth of Binary Tree
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        //if (root == null) return 0;
        int leftMax = root.left == null ? 0 : maxDepth(root.left);
        int rightMax = root.right == null ? 0 : maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}
