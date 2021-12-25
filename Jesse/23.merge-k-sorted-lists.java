/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1){
            return lists[0];
        }
        if(lists.length==0){
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        
        for(int interval =1; interval<lists.length; interval  *= 2){
            System.out.println(interval);
            for(int i =0; i<lists.length-interval;i += 2* interval){
                System.out.println(i);
                lists[i] = merge(lists[i],lists[i+interval]);
                tail.next = lists[i];
            }
        }
        return dummy.next;
    }
    
    ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(l1!=null && l2!= null){
            if(l1.val<l2.val){
                tail.next  = l1;
                l1 = l1.next;
                tail = tail.next;
            }
            else{
                tail.next  = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }
        
        tail.next = l1 != null? l1:l2;
        
        return dummy.next;
        
    }
}
// @lc code=end

