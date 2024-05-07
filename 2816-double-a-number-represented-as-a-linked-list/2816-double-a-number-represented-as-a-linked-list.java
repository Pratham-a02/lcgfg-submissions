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
    public ListNode doubleIt(ListNode head) {
        ListNode nhead = reverse(head);
        ListNode curr = nhead;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        
        while(curr != null){
            int currVal = curr.val *2 + carry;
            int nodeVal = currVal%10;
            carry = currVal/10;
            ListNode nNode = new ListNode(nodeVal);
            ptr.next = nNode;
            ptr = ptr.next;
            curr = curr.next;
        }
        if(carry != 0){
            ListNode nNode = new ListNode(carry);
            ptr.next = nNode;
            ptr = ptr.next;
        }
        
        ListNode ans = dummy.next;
        dummy.next = null;
        
        return reverse(ans);
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