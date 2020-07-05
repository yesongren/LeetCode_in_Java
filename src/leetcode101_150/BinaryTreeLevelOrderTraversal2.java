package leetcode101_150;

import java.util.*;

/**
 * Created by yesongren on 2020/7/2
 * 107. Binary Tree Level Order Traversal II
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelElement = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelElement.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(levelElement);
        }
        Collections.reverse(res);
        return res;
    }
}
