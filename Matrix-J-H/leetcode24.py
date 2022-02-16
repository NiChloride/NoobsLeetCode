2020/02/16
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        newHead = Swap(head)
        return newHead
        
def Swap(node):
    if not node:
        return 
    elif not node.next:
        return node
        
    newNode = node.next
    node.next = newNode.next
    newNode.next = node
    node.next = Swap(node.next)
    return newNode
