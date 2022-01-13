package Jan8;

import myutils.TreeNode;

// 235
class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                // p和q在当前节点一左一右，那当前节点就是目标节点了（BST特性）
                break;
            }
        }

        return root;
    }
}