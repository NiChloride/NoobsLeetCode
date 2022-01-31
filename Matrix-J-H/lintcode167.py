"""
Definition of ListNode
class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    """
    @param l1: the first list
    @param l2: the second list
    @return: the sum list of l1 and l2 
    """
    def addLists(self, l1, l2):
        # write your code here
        num1 = 0
        num2 = 0
        num1 = DFS(l1, num1)
        num2 = DFS(l2, num2)
        summ = num1 + num2
        out = makeList(summ, ListNode(0))
        return out

def DFS(ll, num):
    if not ll.next:
        return ll.val
    
    num += DFS(ll.next, num)
    num = num *10 + ll.val

    return num

def makeList(num, ln):

    print(num)
    ln.val = num % 10
    num -= num % 10
    if num > 0:
        num = str(num)
        num = num[:-1]
        num = int(num)
        ln.next = ListNode(0)
        ln.next = makeList(num, ln.next)
        return ln
    else:
        return ln
