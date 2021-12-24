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
     * @return: the node where the cycle begins. 
     *           If there is no cycle, return null
     */
    ListNode *detectCycle(ListNode *head) {
        // write your code here
        ListNode* ptr1,* ptr2;
        if(head == NULL)
            return NULL;
        ptr1 = head ;
        ptr2 = head;

        while(ptr2->next != NULL && ptr2->next->next != NULL)  //ptr2快指针
        {
            ptr1 = ptr1->next;
            ptr2 = ptr2->next->next;
            if(ptr1 == ptr2)           //快慢指针相遇
            {
                ptr1 = head;			//从头移动ptr1
                while(ptr1 != ptr2)		//同时移动ptr1和ptr2
                {
                    ptr2 = ptr2->next;
                    ptr1 = ptr1->next;
                }
                return ptr1;		//两指针相遇处即为环的入口
            }

        }
        return NULL;
    }
};
