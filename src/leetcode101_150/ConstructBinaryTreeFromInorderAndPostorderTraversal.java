package leetcode101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2020/7/1
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] in, int[] post) {
        Map<Integer, Integer> inPos = new HashMap<>();
        for (int i = 0; i < in.length; ++i) {
            inPos.put(in[i], i);
        }
        return buildTreeForm(post, 0, post.length - 1, 0, inPos);
    }

    public TreeNode buildTreeForm(int[] post, int postStart, int postEnd,
                                  int inStart, Map<Integer, Integer> inPos) {
        if (postStart > postEnd) return null;
        TreeNode root = new TreeNode(post[postEnd]);
        int rootIdx = inPos.get(post[postEnd]);
        int leftLen = rootIdx - inStart;
        root.left = buildTreeForm(post, postStart, postStart + leftLen - 1, inStart, inPos);
        root.right = buildTreeForm(post, postStart + leftLen, postEnd - 1, rootIdx + 1, inPos);
        return root;
    }
}
