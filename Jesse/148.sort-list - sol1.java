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
    public ListNode sortList(ListNode head) {
        int count =0;
        ListNode node = head;
        while(node !=null){
            node = node.next;
            count++;
        }

        if(count <= 1){
            return head;
        }

        node = head;

        for(int i =0; i<count/2-1;i++){
            node = node.next;
        }
        ListNode mid = node.next;
        node.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);

    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy= new ListNode(0);
        ListNode node = dummy;
        while(head1 != null && head2 != null){
            if(head1.val >= head2.val){
                node.next = head2;
                head2 = head2.next;
                node = node.next;
            }
            else{
                node.next = head1;
                head1 = head1.next;
                node = node.next;
            }
        }
        node.next = head1 != null? head1:head2;

        return dummy.next;
    }
}
// @lc code=end

