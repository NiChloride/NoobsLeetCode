/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        Queue<TreeNode> que = new ArrayDeque<>();
        
        Map<TreeNode,TreeNode> relation = new HashMap<>();
        relation.put(root, null);
        
        que.offer(root);
        
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode node = que.poll();
                if(node.left!=null) {
                    que.offer(node.left);
                    relation.put(node.left,node);
                };
                if(node.right!=null){
                    que.offer(node.right);
                    relation.put(node.right,node);
                }
            }
        }
        
        LinkedList<TreeNode> ancestors = new LinkedList<>();
        
        while(p!=null){
            ancestors.addFirst(p);
            p = relation.get(p);
        }
        
        while(q!=null){
            if(ancestors.contains(q)){
                return q;
            }
            q= relation.get(q);
        }
        
        return null;
    }
}
// @lc code=end

