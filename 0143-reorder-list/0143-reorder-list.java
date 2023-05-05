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
        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;
        nHead = reverse(nHead);
        
        ListNode c1 = head;
        ListNode c2 = nHead;
        
        while(c1 != null && c2!= null){
            ListNode f1 = c1.next;
            ListNode f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
        
        return;
    }
    
    public ListNode midNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}