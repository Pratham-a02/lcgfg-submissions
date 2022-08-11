/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast.next!= null && fast.next.next!= null){
            if(slow == fast)
                return true;
            else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return false;
    }
}