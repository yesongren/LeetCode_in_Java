package leetcode601_650;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yesongren on 2020/7/17
 * 623. Add One Row to Tree
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (depth == d - 1) {
                    TreeNode newLeft = new TreeNode(v);
                    TreeNode newRight = new TreeNode(v);
                    if (t.left != null) newLeft.left = t.left;
                    if (t.right != null) newRight.right = t.right;
                    t.left = newLeft;
                    t.right = newRight;
                    continue;
                }
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            depth++;
        }
        return root;
    }
}
