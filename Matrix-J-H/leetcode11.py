#2022/02/14
class Solution:
    def maxArea(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        maxVol = 0
        
        while l < r:
            if height[l] < height[r]:
                if getVolume(r-l, min(height[l], height[r])) > maxVol:
                    maxVol = getVolume(r-l, min(height[l], height[r]))
                l += 1
            else:
                if getVolume(r-l, min(height[l], height[r])) > maxVol:
                    maxVol = getVolume(r-l, min(height[l], height[r]))
                r -= 1
        return maxVol
            
def getVolume(w, h):
    vol = w*h
    return vol
