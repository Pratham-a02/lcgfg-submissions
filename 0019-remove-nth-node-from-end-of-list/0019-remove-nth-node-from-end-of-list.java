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
class Solution{
    public ListNode removeNthFromEnd(ListNode head,int n){
        int len = length(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        int k = len - n;
        int ptr = 0;
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