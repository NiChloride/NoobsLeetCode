package Jan7;

import myutils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 501
class FindModeInBinarySearchTree {
    Map<Integer, Integer> count = new HashMap<>();
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        dfs(root);

        List<Integer> list = new LinkedList<>();
        for (Integer i : count.keySet()) {
            if (count.get(i) == maxCount) {
                list.add(i);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        count.put(node.val, count.getOrDefault(node.val, 0) + 1);

        if (count.get(node.val) > maxCount) {
            maxCount = count.get(node.val);
        }

        dfs(node.right);
    }
}