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
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        // in order traversal of a BST will rank nodes from smallest to greatest
        //left-root-right
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        stk.offerLast(root);
        while(root.left != null)
        {
            stk.offerLast(root.left);
            root = root.left;
        }
        while(!stk.isEmpty())
        {
            root = stk.pollLast();
            result.add(root.val);
            if (root.right!=null)
            {
                root = root.right;
                stk.offerLast(root);
                while(root.left!=null)
                {
                    stk.offerLast(root.left);
                    root = root.left;
                }
            }
        }

        return result.get(k-1);
        
    }


  
}