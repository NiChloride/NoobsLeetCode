from math import floor, ceil

class MedianFinder:

    def __init__(self):
        self.data = []
        self.centre = float(0.0)
        self.median = 0

    def addNum(self, num: int) -> None:
        if not self.data:
            self.data.append(num)
            return
        
        if num >= self.median:
            for i in range(floor(self.centre), len(self.data)):
                if num < self.data[i]:
                    self.data.insert(i, num)
                    return
            self.data.append(num)
        elif num < self.median:
            for i in range(ceil(self.centre)):
                if num < self.data[i]:
                    self.data.insert(i, num)
                    return
            self.data.insert(ceil(self.centre), num)
            
    def findMedian(self) -> float:
        datasize = len(self.data)
        
        if datasize%2 == 0:
            self.centre = (datasize-1)/2
            small = self.data[floor(self.centre)]
            large = self.data[ceil(self.centre)]
            self.median = (small+large)/2
            return self.median
        elif datasize%2 != 0:
            self.centre = floor(datasize/2)
            self.median = self.data[self.centre]
            return self.median

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()

#Solution using heapq#
import heapq

class MedianFinder:

    def __init__(self):
        self.small, self.large = [], []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.small, -1 * num)
        
        #make sure every num in self.small is <= every num in self.large
        if(self.small and self. large and (-1 * self.small[0]) > self.large[0]):
             val = -1 * heqpq.heappop(self.small)
             heapq.heappush(self.large, val)
              
        #check if size of self.small and self.large are the same
        if len(self.small) > len(self.large) + 1:
           val = -1 * heqpq.heappop(self.small)
           heapq.heappush(self.large, val)
        if len(self.large) > len(self.small) + 1:
           val = heqpq.heappop(self.large)
           heapq.heappush(self.small, -1 * val)
          
    def findMedian(self) -> float:
        if len(self.small) > len(self.large):
          return -1 * self.small[0]
        if len(self.large) > len(self.small):
          return self.large[0]
        
        return (-1 * self.small[0] + self.large[0])/2

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
