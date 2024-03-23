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
    public void reorderList(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode temp = slow.next;
        slow.next = null;
        
        ListNode curr = temp;
        ListNode pre = null;
        while(curr != null){
            ListNode ntemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = ntemp;
        }
        
        
        
        ListNode l1 = head;
        ListNode l2 = pre;
        
        while(l1 != null && l2 != null){
            ListNode c1 = l1.next;
            ListNode c2 = l2.next;
            
            l1.next = l2;
            l2.next = c1;
            l1 = c1;
            l2 = c2;
        }
    }
}