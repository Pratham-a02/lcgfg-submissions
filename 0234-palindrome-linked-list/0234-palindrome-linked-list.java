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
    public boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode ptr = slow.next;
        slow.next = null;
        ListNode curr2 = reverse(ptr);
        ListNode curr1 = head;
        
        while(curr1 != null && curr2 != null){
            if(curr1.val != curr2.val){
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return true;
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