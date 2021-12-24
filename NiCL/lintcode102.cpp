/**
 * Definition of singly-linked-list:
 * class ListNode {
 * public:
 *     int val;
 *     ListNode *next;
 *     ListNode(int val) {
 *        this->val = val;
 *        this->next = NULL;
 *     }
 * }
 */

class Solution {
public:
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    bool hasCycle(ListNode * head) {
        // write your code here
        ListNode * fast = head; //fast pointer
        ListNode * slow = head; //slow pointer
        if(!head)
        {
            return false;
        }
        while(1)
        {
            if (fast->next)
            {
                fast = fast->next;
                slow = slow->next;
                if (fast->next)
                {
                    fast = fast->next;
                    if (fast==slow)
                    {
                        return true;
                    }
                }
                else
                {
                    return false;
                }
            }
            else{
                return false;
            }
        }
    }
};