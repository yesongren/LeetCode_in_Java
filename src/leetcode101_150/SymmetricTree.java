package leetcode101_150;

/**
 * Created by yesongren on 2019/10/14
 * LeetCode #101: Symmetric Tree
 */
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && isMirror(n1.left, n2.right)
                && isMirror(n1.right, n2.left);
    }
}
