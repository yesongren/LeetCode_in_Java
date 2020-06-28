package leetcode401_450;

/**
 * Created by yesongren on 2020/6/28
 * 437. Path Sum III
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathForm(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathForm(TreeNode root, int sum) {
        if (root == null) return 0;
        int cnt = 0;
        if (root.val == sum) cnt++;
        cnt += pathForm(root.left, sum - root.val);
        cnt += pathForm(root.right, sum - root.val);
        return cnt;
    }
}
