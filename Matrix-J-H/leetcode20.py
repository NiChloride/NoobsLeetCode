class Solution:
    def isValid(self, s: str) -> bool:
        left = ['(', '{', '[']
        temp = []
        
        for c in s:
            if c in left:
                temp.append(c)
            elif temp:
                if c == ')':
                    if temp.pop() != '(':
                        return False
                elif c == '}':
                    if temp.pop() != '{':
                        return False
                elif c == ']':
                    if temp.pop() != '[':
                        return False
                return False
            
        if len(temp) == 0:
            return True
        else:
            return False
