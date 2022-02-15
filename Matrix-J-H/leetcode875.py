#2020/02/15
from math import ceil

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        res = r
        
        def Timetaken(kvalue):
            hrs = 0
            for i in range(len(piles)):
                hrs += ceil(piles[i] / kvalue)
            return hrs
            
        while l <= r:
            k = (l + r) // 2
            
            if Timetaken(k) <= h:
                res = min(res, k)
                r = k - 1
            else:
                l = k + 1
        
        return res
