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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        
        int len = length(head);
        
        if(k == 0 || k%len == 0) return head;
        
        k = k%len;
        int rLen = len - k;
        
        ListNode curr = head;
        int cnt = 1;
        
        while(cnt != rLen){
            cnt++;
            curr = curr.next;
        }
        
        ListNode temp = curr.next;
        curr.next = null;
        
        curr = temp;
        while(curr.next != null){
            curr = curr.next;
        }
        
        curr.next = head;
        return temp;
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