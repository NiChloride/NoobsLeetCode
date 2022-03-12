from collections import deque

def valid_trans(word1, word2) -> bool:
    diff = 0
    for i in range(len(word1)):
        if (word1[i] != word2[i]):
            diff += 1
    return diff == 1



class Solution:
    """
    @param: start: a string
    @param: end: a string
    @param: dict: a set of string
    @return: An integer
    """

                
    def ladderLength(self, start, end, dict):
        # write your code here
        if start == end:
            return 1
        ans = 1
        q = [start]
        abc = 'abcdefghijklmnopqrstuvwxyz'
        while q:
            ans += 1
            size = len(q)
            for _ in range(size):
                cur = list(q.pop(0))
                for i in range(len(cur)):
                    ch = cur[i]
                    for j in range(26):
                        cur[i] = abc[j]
                        new_word = ''.join(cur)
                        if new_word == end:
                            return ans
                        if new_word in dict:
                            q.append(new_word)
                            dict.remove(new_word)
                    cur[i] = ch
        return 0
                                
        