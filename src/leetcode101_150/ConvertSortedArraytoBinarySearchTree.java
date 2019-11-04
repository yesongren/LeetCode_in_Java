package leetcode101_150;

/**
 * Created by yesongren on 2019/11/4
 */
public class ConvertSortedArraytoBinarySearchTree {
    /**
     * #108. Convert Sorted Array to Binary Search Tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums ==  null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root  = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}
