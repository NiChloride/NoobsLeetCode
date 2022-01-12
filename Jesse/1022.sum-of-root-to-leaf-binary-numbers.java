/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
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
    public int sumRootToLeaf(TreeNode root) {
        
        int res = 0;
        
        Queue<Pair<TreeNode,Integer>> que = new ArrayDeque();
        que.offer(new Pair(root, 0));
        
        
        while(!que.isEmpty()){
            Pair<TreeNode,Integer> temp = que.poll();
            TreeNode node = temp.getKey();
            int current = temp.getValue();
            current = current << 1 | node.val;
            if(node.left == null && node.right ==null){
                res += current;
            }
            if(node.right!=null) que.offer(new Pair(node.right,current));
            if(node.left!=null) que.offer(new Pair(node.left,current));
        }
        
        
        return res;
        
    }
}
// @lc code=end

