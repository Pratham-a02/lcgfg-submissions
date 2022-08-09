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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!= null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int firstVal = 0;
        int secVal = 0;
        int total = 0;
        int carry = 0;
        while(l1 != null && l2 != null){
            firstVal = l1.val;
            secVal = l2.val;
            total = firstVal + secVal + carry;
            
            carry = total/10;
            total %= 10;
            ListNode newNode = new ListNode(total);
            dummy.next = newNode;
            dummy = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            total = l1.val + carry;
            
            carry = total/10;
            total %= 10;
            
            ListNode newNode = new ListNode(total);
            dummy.next = newNode;
            dummy = newNode;
            l1 = l1.next;
        }
        while(l2 != null){
            total = l2.val + carry;
            
            carry = total/10;
            total %= 10;
            
            ListNode newNode = new ListNode(total);
            dummy.next = newNode;
            dummy = newNode;
            l2 = l2.next;
        }
        
        if(carry!= 0){
            ListNode newNode = new ListNode(carry);
            dummy.next = newNode;
        }
        
        return (reverseList(head.next));
    }
    
}