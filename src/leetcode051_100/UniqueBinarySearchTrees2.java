package leetcode051_100;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yesongren on 2019/10/8
 * LeetCode #095- Unique Binary Search Trees II
 */
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return Collections.emptyList();
        return genTrees(1, n);
    }

    private TreeNode cloneTrees(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = root.left;
        newRoot.right = root.right;
        return newRoot;
    }

    private List<TreeNode> genTrees(int low, int high) {
        if (low > high) return new ArrayList<>();
        List<TreeNode> res = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            List<TreeNode> lefts = genTrees(low, i - 1);
            List<TreeNode> rights = genTrees(i + 1, high);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = cloneTrees(left);
                    root.right = cloneTrees(right);
                    res.add(root);
                }
            }
        }
        return res;
    }

    /************* simplify *************/

    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) return new ArrayList<>();
        return genTreeList(1, n);
    }

    private List<TreeNode> genTreeList(int low, int high) {
        List<TreeNode> list = new ArrayList<>();
        if (low > high) list.add(null);

        for (int idx = low; idx <= high; idx++) {
            List<TreeNode> leftList = genTreeList(low, idx - 1);
            List<TreeNode> rightList = genTreeList(idx + 1, high);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
