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

//left-right-root
//pop stack to get curnode
//add curnode to front (index 0)
//push left child into stack
//push right child into stack
//repeat. this way, you always end up with left-right-root (reverse of root-right-left)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curnode = stack.pop();
            result.add(0, curnode.val);
            if (curnode.left != null)
            {
                stack.push(curnode.left);
            } 
            if (curnode.right != null) 
            {
                stack.push(curnode.right);
            }
        }
        return result;
    }
}