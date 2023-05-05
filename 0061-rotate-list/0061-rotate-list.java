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
    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null) return head;
        int length = calculateLength(head);
        if(k == 0 || k%length == 0) return head;
        k = k%length;
        int rlen = length - k;
        ListNode curr = head;
        int len = 1;
        while(len != rlen){
            len++;
            curr = curr.next;
        }
        
        ListNode nHead = curr.next;
        curr.next = null;
        
        curr = nHead;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = head;
        return nHead;
    }
    
    public int calculateLength(ListNode head){
        int len = 0;
        ListNode curr = head;
        
        while(curr != null){
            len++;
            curr = curr.next;
        }
        
        return len;
    }
}