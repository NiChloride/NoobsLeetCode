# -*- coding:utf-8 -*-
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    def TreeDepth(self, pRoot):
        # write code here
        max_ = 0
        if not pRoot:
            return 0
         
        def traversal(root, count):
            nonlocal max_
            if max_<count:
                max_ = count
            if not root:
                return
            if root.left:
                traversal(root.left,count+1)
            if root.right:
                traversal(root.right, count+1)
        traversal(pRoot, 1)
        return max_