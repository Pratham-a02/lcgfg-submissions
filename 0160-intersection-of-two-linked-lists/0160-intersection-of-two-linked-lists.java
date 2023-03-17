/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode curr = headA;
        while(curr.next!= null){
            curr = curr.next;
        }
        curr.next = headB;
        
        ListNode slow = headA;
        ListNode fast = headA;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(slow != fast){
            curr.next = null;
            return null;
        }
        ListNode temp = headA;
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }
        curr.next = null;
        return temp;
    }
}