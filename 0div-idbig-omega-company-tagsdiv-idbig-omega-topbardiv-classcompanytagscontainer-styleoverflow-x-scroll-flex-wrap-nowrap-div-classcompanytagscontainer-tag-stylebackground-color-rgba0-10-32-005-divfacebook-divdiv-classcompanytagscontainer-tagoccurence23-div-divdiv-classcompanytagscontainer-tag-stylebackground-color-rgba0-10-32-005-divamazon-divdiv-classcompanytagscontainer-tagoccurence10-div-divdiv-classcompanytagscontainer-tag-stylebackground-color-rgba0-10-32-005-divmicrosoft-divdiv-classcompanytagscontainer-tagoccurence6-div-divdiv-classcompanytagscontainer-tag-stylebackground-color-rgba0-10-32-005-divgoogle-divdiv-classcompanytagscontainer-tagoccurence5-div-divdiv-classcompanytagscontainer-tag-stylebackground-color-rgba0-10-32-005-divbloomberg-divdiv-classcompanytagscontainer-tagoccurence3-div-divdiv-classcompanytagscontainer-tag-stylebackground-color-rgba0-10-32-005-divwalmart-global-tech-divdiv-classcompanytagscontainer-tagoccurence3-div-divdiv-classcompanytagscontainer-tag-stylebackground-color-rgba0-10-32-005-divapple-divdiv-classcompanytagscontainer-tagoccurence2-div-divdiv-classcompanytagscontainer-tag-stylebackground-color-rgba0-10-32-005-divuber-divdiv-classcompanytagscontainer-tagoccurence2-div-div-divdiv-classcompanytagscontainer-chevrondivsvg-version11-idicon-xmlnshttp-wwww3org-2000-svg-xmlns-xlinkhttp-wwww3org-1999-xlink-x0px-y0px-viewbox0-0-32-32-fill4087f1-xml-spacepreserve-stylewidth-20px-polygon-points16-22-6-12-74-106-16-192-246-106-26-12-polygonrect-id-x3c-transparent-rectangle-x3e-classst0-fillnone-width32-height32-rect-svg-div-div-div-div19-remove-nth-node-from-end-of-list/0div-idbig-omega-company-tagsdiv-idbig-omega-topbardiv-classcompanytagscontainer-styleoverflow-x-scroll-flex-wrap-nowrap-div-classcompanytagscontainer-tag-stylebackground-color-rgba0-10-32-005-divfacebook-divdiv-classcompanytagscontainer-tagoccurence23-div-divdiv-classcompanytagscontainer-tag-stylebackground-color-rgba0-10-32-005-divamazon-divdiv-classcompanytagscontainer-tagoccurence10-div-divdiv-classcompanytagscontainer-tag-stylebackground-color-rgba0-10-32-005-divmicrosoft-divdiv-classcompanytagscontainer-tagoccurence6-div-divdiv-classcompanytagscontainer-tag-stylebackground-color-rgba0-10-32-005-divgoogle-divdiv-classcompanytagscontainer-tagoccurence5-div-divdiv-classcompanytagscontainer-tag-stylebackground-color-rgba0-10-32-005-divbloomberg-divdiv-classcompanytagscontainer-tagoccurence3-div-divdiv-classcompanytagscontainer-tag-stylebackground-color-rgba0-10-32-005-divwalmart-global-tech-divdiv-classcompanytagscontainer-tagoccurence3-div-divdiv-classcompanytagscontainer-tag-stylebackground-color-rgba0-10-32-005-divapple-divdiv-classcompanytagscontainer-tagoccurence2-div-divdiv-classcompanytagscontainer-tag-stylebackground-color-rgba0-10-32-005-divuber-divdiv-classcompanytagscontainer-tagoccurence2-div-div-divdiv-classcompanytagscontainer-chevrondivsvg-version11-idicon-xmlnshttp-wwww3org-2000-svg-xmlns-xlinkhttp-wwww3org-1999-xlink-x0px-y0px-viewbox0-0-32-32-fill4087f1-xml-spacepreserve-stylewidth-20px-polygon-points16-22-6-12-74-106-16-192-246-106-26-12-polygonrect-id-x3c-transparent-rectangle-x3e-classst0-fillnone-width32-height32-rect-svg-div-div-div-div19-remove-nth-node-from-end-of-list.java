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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int ptr = 0;
        int len = length(head);
        int k = len - n;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while(ptr != k){
            ptr++;
            curr = curr.next;
        }
        
        curr.next = curr.next.next;    
        
        return dummy.next;
    }
    
    public int length(ListNode head){
        int len = 0;
        
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
}