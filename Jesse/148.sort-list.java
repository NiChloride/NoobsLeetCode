/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode nextSplit = new ListNode();
    ListNode tail = new ListNode();
    
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        int n = getCount(head);
        
        ListNode subBegin = head;
        ListNode dummyHead = new ListNode();
        
        for(int size =1;size<n;size= size*2){
            
            tail = dummyHead;
            while(subBegin!= null){
                if(subBegin.next == null){
                    tail.next = subBegin;
                    break;
                }
                ListNode mid = split(subBegin,size);
                merge(subBegin, mid);
                subBegin = nextSplit;
            }
            
            subBegin = dummyHead.next;
            
        }
        
        return dummyHead.next;
        
       
    }
    
    ListNode split(ListNode start, int size){
        
        ListNode beforeMid = start;
        ListNode beforeNextSplit = start.next;
        
        for(int i=1;i<size&&(beforeMid.next != null || beforeNextSplit.next!= null);i++){
            if(beforeMid.next != null){
                beforeMid = beforeMid.next;
            }
            if(beforeNextSplit.next != null){
                beforeNextSplit = beforeNextSplit.next.next != null ? beforeNextSplit.next.next : beforeNextSplit.next;
            }
            
        }
        ListNode mid = beforeMid.next;
        beforeMid.next = null;
        nextSplit = beforeNextSplit.next;
        beforeNextSplit.next = null;
        return mid;
    }
    
    void merge(ListNode ln1, ListNode ln2){
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while(ln1!= null && ln2 != null){
            if(ln1.val< ln2.val){
                node.next = ln1;
                ln1 = ln1.next;
                node = node.next;
            }
            else{
                node.next = ln2;
                ln2 = ln2.next;
                node = node.next;
            }
        }
        node.next = ln1 == null? ln2:ln1;
        while(node.next != null){
            node = node.next;
        }
        
        tail.next = dummy.next;
        tail = node;
    }
    
    int getCount(ListNode head){
        int count = 0;
        ListNode node = head;
        while(node!=null){
            node = node.next;
            count++;
        }
        return count;
    }
}
// @lc code=end

