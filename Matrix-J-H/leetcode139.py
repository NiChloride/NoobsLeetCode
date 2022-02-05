#core idea is to work backward in s, use each word in wordDict to fit the slices in s

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        out = [False] * (len(s)+1) #one more entries for base case
        out[-1] = True #Initialize Base case as True
        
        
        for i in range(len(s) - 1, -1, -1):# from the last index to 0
            for word in wordDict:
                if i + len(word) <= len(s) and s[i:i+len(word)] == word:
                    out[i] = out[i+len(word)]
                if out[i]: #if out[i] is True, no need to compare the rest of the words in wordDict
                    break
        
        return out[0] #If cannot be segmented as required, out[0] will be False
