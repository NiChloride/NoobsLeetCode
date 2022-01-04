/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
     //add to queue in the order of root->left->right, FIFO
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here

        
        List<Integer> traversal = new ArrayList<Integer>();
        if (root == null)
        {
            return traversal;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty())
        {
            TreeNode current = stack.pollLast();
            traversal.add(current.val);
            if(current.right != null)
            {
                stack.offerLast(current.right);
            }
            if(current.left != null) //this way left nodes will always be on top of stack
            {
                stack.offerLast(current.left);
            }
        }

        return traversal;
    }
}