package leetcode201_250;

import util.TreeNode;

/**
 * Created by yesongren on 2020/7/23
 * 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) return countNodes(root.right) + (1 << leftLevel);
        else return countNodes(root.left) + (1 << rightLevel);
    }

    public int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            level++;
        }
        return level;
    }
}
