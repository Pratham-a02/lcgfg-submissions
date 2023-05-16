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
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode c1 = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(c1 != null && c1.next != null){
            ListNode c2 = c1.next;
            ListNode nHead = c1.next.next;
            c1.next = nHead;
            c2.next = c1;
            prev.next = c2;
            prev = c1;
            c1 = nHead;
        }
        return dummy.next;
    }
}