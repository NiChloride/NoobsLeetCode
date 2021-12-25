# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def __init__(self):
        self.visit = []
    
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
            
        self.inorderTraversal(root.left)

        self.visit.append(root.val)

        self.inorderTraversal(root.right)
        
        return self.visit
