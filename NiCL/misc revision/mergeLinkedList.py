#This solution uses O(N) time
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution_recursive:
    def Merge(self , pHead1: ListNode, pHead2: ListNode) -> ListNode:
        # write code here
        if not pHead1:
            return pHead2
        elif not pHead2:
            return pHead1
        
        if pHead1.val < pHead2.val:
            pHead1.next = self.Merge(pHead1.next, pHead2)
            return pHead1
        else:
            pHead2.next = self.Merge(pHead1, pHead2.next)
            return pHead2