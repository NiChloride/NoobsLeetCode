class Solution:
    """
    @param s: A string
    @return: whether the string is a valid parentheses
    """

    def isValidParentheses(self, s):
        from collections import deque
        # write your code here
        parDict = {   
        ')': '(',
        '}': '{',
        ']': '['
        }
        left = ['(', '{', '[']

        q = deque()
        
        for p in s:
            if p in left:
                q.append(p)
            else:
                if not q or parDict[p] != q.pop():
                    return False

            
        if q:
            return False

        return True
