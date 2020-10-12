package leetcode751_800;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/10/12
 * 783. Minimum Distance Between BST Nodes
 */
public class MinimumDistanceBetweenBSTNodes {
    public List<Integer> res = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        inorder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            min = Math.min((res.get(i) - res.get(i - 1)), min);
        }
        return min;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
