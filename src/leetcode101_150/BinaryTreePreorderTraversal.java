package leetcode101_150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yesongren on 2019/10/29
 * #144. Binary Tree Preorder Traversal
 */
public class BinaryTreePreorderTraversal {
    // Recursive solution
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) helper(root.left, res);
            if (root.right != null) helper(root.right, res);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        // stack
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }
}
