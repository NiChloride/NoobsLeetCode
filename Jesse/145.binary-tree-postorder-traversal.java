/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        TreeNode LastNode = root;
        
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            
            if(node.right!=null && LastNode != node.right){
                stack.push(node);
                node = node.right;
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
            else{
                res.add(node.val);
                LastNode = node;
            }
        }
        
        return res;
    }
}
// @lc code=end

