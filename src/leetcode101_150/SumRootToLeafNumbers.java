package leetcode101_150;

/**
 * Created by yesongren on 2020/7/6
 * 129. Sum Root to Leaf Numbers
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int i) {
        if(root == null) return 0;
        int tmp = i * 10 + root.val;
        if (root.left == null && root.right == null) return tmp;
        return helper(root.left, tmp) + helper(root.right, tmp);
    }
}
