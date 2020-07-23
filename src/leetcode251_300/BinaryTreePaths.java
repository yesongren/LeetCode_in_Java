package leetcode251_300;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesongren on 2020/7/23
 * 257. Binary Tree Paths
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        genPath(root, "", res);
        return res;
    }

    public void genPath(TreeNode root, String path, List<String> res) {
        if (root == null) return;
        path += root.val;
        if (root.left == null && root.right == null) {  // if leaf node
            res.add(path);
        } else {
            path += "->";
            genPath(root.left, path, res);
            genPath(root.right, path, res);
        }
    }
}
