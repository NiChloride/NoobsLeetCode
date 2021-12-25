/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head ==null || head.next == null ){
            return head;
        }
        int n = getCount(head);
        k = k%n;
        
        if(k == 0){
            return head;
        }
        
        ListNode node = head;
        
        for(int i =0 ;i<n-k-1;i++){
            node = node.next;
        }
        
        ListNode newHead = node.next;
        node.next = null;
        node = newHead;
        while(node.next != null){
            node = node.next;
        }
        
        node.next = head;
        return newHead;
        
    }
    
    int getCount(ListNode head){
        int count =0;
        ListNode node = head;
        
        while(node != null){
            node = node.next;
            count++;
        }
        
        return count;
    }
}
// @lc code=end

