package leetcode051_100;

import java.util.Stack;

/**
 * Created by yesongren on 2019/10/11
 * LeetCode #098- Validate Binary Search Tree
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

    /************** sol 2 - inorder traversal **************/

    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
