package Jan5;


import myutils.TreeNode;

// 110
class BalancedBinaryTree {
    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getHeight(node.left);
        if (left == -1) {
            return -1;
        }

        int right = getHeight(node.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
}