package leetcode101_150;

/**
 * Created by yesongren on 2019/10/15
 * LeetCode #111: Minimum Depth of Binary Tree
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null || root.right == null) return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
