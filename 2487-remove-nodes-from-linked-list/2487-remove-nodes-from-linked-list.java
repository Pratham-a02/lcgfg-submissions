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
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode nhead = reverse(head);
        int max = nhead.val;
        ListNode prev = nhead;
        ListNode curr = prev.next;
        
        while(curr!= null){
            if(curr.val>=max){
                max = curr.val;
                prev = curr;
                curr = curr.next;
            }
            else{
                prev.next = curr.next;
                curr = prev.next;
            }
        }
        
        ListNode n_ =  reverse(nhead);
        return n_;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}