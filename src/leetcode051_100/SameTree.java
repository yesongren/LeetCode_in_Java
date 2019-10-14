package leetcode051_100;

/**
 * Created by yesongren on 2019/10/14
 * LeetCode #100: Same Tree
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean origin(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
