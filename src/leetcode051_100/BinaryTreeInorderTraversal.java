package leetcode051_100;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yesongren on 2019/10/7
 * 94. Binary Tree Inorder Traversal
 */

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            p = tmp.right;
        }
        return res;
    }
}
