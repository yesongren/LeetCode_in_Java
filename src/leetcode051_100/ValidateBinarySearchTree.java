package leetcode051_100;

/**
 * Created by yesongren on 2019/10/11
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return BSTUtil (root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean BSTUtil(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;   //如果是Integer, 可以用大于或者小于号，但下方递归的边界条件node.val需要加一，减一
        return BSTUtil (node.left, min, node.val) &&
                BSTUtil (node.right, node.val, max);
    }
}
