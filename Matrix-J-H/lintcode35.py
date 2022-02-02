"""
Definition of ListNode
class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    """
    @param head: n
    @return: The new head of reversed linked list.
    """
    def reverse(self, head):
        # write your code here
        revlist = []
        revlist = dfs(head, revlist)
        dmNode = ListNode(0,ListNode(0))
        rNode = dmNode.next
        while revlist:
            rNode.val = revlist.pop(0)
            if revlist:
                rNode.next = ListNode(None)
                rNode = rNode.next
            else: 
                break
        
        return dmNode.next

def dfs(ln, lst):
    if not ln.next:
        lst.append(ln.val)
        return lst

    lst = dfs(ln.next, lst)

    lst.append(ln.val)

    return lst
