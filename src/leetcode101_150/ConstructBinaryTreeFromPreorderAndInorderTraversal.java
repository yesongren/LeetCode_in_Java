package leetcode101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2020/7/1
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> inPos = new HashMap<>();
        for (int i = 0; i < in.length; ++i) {
            inPos.put(in[i], i); // key记录中序遍历元素值， value记录元素下标
        }
        return buildTreeForm(pre, 0, pre.length - 1, 0, inPos);
    }

    public TreeNode buildTreeForm(int[] pre, int preStart, int preEnd,
                                  int inStart, Map<Integer, Integer> inPos) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIdx = inPos.get(pre[preStart]);
        int leftLen = rootIdx - inStart;
        root.left = buildTreeForm(pre, preStart + 1, preStart + leftLen, inStart, inPos);
        root.right = buildTreeForm(pre, preStart + leftLen + 1, preEnd - 1, rootIdx + 1, inPos);
        return root;
    }
}
