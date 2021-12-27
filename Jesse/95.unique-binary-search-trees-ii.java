/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    public List<TreeNode> generateTrees(int n) {
        
        return formTree(1,n);
            
    }
    
    ArrayList<TreeNode> formTree(int i, int n){
        TreeNode root = new TreeNode(i);
        ArrayList<TreeNode> res = new ArrayList<>();
        
        if(i>n){
            res.add(null);
            return res;
        }
        
        for(int m =i; m<= n;m++){
            
            ArrayList<TreeNode> leftTrees = formTree(i, m - 1);
            ArrayList<TreeNode> rightTrees = formTree(m+1, n);
            
            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode head = new TreeNode(m);
                    head.left = left;
                    head.right = right;
                    res.add(head);
                }
            }
            
        }
        
        return res;
        
        
        
    }
}
// @lc code=end

