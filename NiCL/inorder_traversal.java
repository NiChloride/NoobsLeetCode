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
//left-root-right
public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        //append all left-most nodes to a stack first
        //pop the stack to obtain curnode
        //add the value of curnode to result
        //if curnode has a right child, curnode = right child, add right child to stack
        //repeat from the beginning step
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<Integer>();
        stack.addLast(root);
        TreeNode curnode = root;
        if(root==null)
        {
            return result;
        }
        while(curnode.left!=null)
        {
            stack.addLast(curnode.left);
            curnode = curnode.left;
        }

        while(!stack.isEmpty())
        {
            curnode = stack.pollLast(); 
            result.add(curnode.val);
            if(curnode.right!=null)
            {
                curnode = curnode.right;
                stack.addLast(curnode);
                while(curnode.left!=null)
                {
                    stack.addLast(curnode.left);
                    curnode = curnode.left;
                }

            }
        }

        return result;
    }
}