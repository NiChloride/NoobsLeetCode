/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        TreeNode last = root;
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        while(current != null){
            if(val > current.val){
                if(current.right == null){
                    current.right = new TreeNode(val);
                    break;
                }
                current = current.right;
            }
            else if(val<current.val){
                if(current.left == null){
                    current.left = new TreeNode(val);
                    break;
                }
                current = current.left;
            }
        }
        
        return root;
    }
}
// @lc code=end

