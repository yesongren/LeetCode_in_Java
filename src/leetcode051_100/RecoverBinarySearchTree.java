package leetcode051_100;

import util.TreeNode;

/**
 * Created by yesongren on 2019/11/22
 * #099. Recover Binary Search Tree
 */
public class RecoverBinarySearchTree {
    TreeNode first = null, second = null, pre = null;

    public void recoverTree(TreeNode root) {
        findWrongNodes(root);
        swap(first, second);
    }

    private void findWrongNodes(TreeNode root) {
        if (root == null) return;
        findWrongNodes(root.left);
        if (pre != null && pre.val > root.val) {
            second = root;
            if (first == null) first = pre;
            else return;
        }
        pre = root;
        findWrongNodes(root.right);
    }

    private void swap(TreeNode n1, TreeNode n2) {
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
