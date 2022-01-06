package Jan5;

import myutils.TreeNode;

// 111
class MinimumDepthofBinaryTree {
    public static int getMinDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getMinDepth(node.left);
        int rightDepth = getMinDepth(node.right);

        if (node.left != null && node.right == null) {
            return 1 + leftDepth;
        }

        if (node.left == null && node.right != null) {
            return 1 + rightDepth;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }
}