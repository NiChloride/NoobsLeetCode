package Jan6;

import myutils.TreeNode;

import java.util.LinkedList;
import java.util.List;

// 257
class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        traverse(root, "", ans);
        return ans;
    }

    public void traverse(TreeNode node, String path, List<String> ans) {
        path += String.valueOf(node.val);
        //path += node.val;
        if (node.left == null && node.right == null) {
            ans.add(path);
            return;
        }

        if (node.left != null) {
            traverse(node.left, path + "->", ans);
        }

        if (node.right != null) {
            traverse(node.right, path + "->", ans);
        }
    }
}