class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        compre = strs[0]
        strs.pop(0)
        
        for word in strs:
            temp = ''
            for char in word:
                if char in compre:
                    temp += char
                else:
                    break
            compre = temp
            
        return compre
