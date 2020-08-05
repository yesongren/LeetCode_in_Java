package leetcode301_350;

import util.TreeNode;

/**
 * Created by yesongren on 2020/8/5
 * 337. House Robber III
 */
public class HouseRobber3 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = post(root);
        return Math.max(res[0], res[1]);
    }

    private int[] post(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] left = post(root.left);
        int[] right = post(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
