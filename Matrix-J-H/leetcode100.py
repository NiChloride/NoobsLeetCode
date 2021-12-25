# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:  
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not (p and q): # if p and q is empty, return True
            return True
        
        if (p == None or q == None or p.val != q.val): # if one node is none, i.e. structual difference, return false
            return False
        
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right);
