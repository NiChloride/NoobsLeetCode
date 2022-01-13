package Jan7;

import myutils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 113
class PathSum2 {
    List<List<Integer>> ans = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans.clear();
        path.clear();
        if (root == null) {
            return ans;
        }
        path.add(root.val);
        dfs(root, targetSum - root.val);
        return ans;
    }

    public void dfs(TreeNode node, int targetSum) {
        if (node.left == null && node.right == null && targetSum == 0) {
            ans.add(new LinkedList<>(path));
            return;
        } else if (node.left == null && node.right == null) {
            return;
        }

        if (node.left != null) {
            path.add(node.left.val);
            targetSum -= node.left.val;
            dfs(node.left, targetSum);
            targetSum += node.left.val;
            path.pollLast();
        }

        if (node.right != null) {
            path.add(node.right.val);
            targetSum -= node.right.val;
            dfs(node.right, targetSum);
            targetSum += node.right.val;
            path.pollLast();
        }

        return;
    }
}