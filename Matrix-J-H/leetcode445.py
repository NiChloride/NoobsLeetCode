# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        l1lst = Extract(l1)
        l2lst = Extract(l2)
        
        l3 = None
        carry = 0
        
        while l1lst or l2lst or carry:
            summ = carry
            
            summ += l1lst.pop() if l1lst else 0
            summ += l2lst.pop() if l2lst else 0
            
            newNode = ListNode(summ%10)
            newNode.next = l3
            l3 = newNode
            
            carry = summ // 10
        return l3
        
def Extract(node):
    out = []
    
    while node:
        out.append(node.val)
        node = node.next
    
    return out
