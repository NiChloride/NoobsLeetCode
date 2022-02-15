"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

from collections import deque

class Solution:
    """
    @param root: An object of TreeNode, denote the root of the binary tree.
    This method will be invoked first, you should design your own algorithm 
    to serialize a binary tree which denote by a root node to a string which
    can be easily deserialized by your own "deserialize" method later.
    """
    def serialize(self, root):
        # write your code here
        if not root:
            return ''

        q = deque()
        serializeTree = []
        q.append(root)

        while q:

            node = q.popleft()

            serializeTree.append(str(node.val) if node else '#')

            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)
            
        
        print(' '.join(serializeTree))
        return ' '.join(serializeTree)