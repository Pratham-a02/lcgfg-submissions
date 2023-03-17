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
    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        // ListNode nl1 = reverseList(l1);
        // ListNode nl2 = reverseList(l2);
        ListNode dummy = new ListNode(-1);
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode ptr = dummy;
        int carry = 0;
        while(ptr1 != null && ptr2 != null){
            int sum = ptr1.val + ptr2.val + carry;
            carry = sum/10;
            int data = sum%10;
            ListNode node = new ListNode(data);
            ptr.next = node;
            ptr = ptr.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        while(ptr1 != null){
            int sum = ptr1.val + carry;
            carry = sum/10;
            int data = sum%10;
            ListNode node = new ListNode(data);
            ptr.next = node;
            ptr = ptr.next;
            ptr1 = ptr1.next;
        }
        while(ptr2 != null){
            int sum = ptr2.val + carry;
            carry = sum/10;
            int data = sum%10;
            ListNode node = new ListNode(data);
            ptr.next = node;
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }
        
        if(carry != 0){
            ListNode node = new ListNode(carry);
            ptr.next = node;
            ptr = ptr.next;
        }
        
        return dummy.next;
    }
}