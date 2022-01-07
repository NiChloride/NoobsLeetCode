package Jan7;

import myutils.TreeNode;

import java.util.LinkedList;
import java.util.List;

// 98
class ValidateBinarySearchTree {
    List<Integer> list = new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        boolean flag = true;
        dfs(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}