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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;
        
        if(l1 == null)
            return l2;
        
        if(l2 == null)
            return l1;
        
        int carry = 0;
        int total = 0;
        int firstVal = 0;
        int secVal = 0;
        while(l1 != null && l2 != null){
            firstVal = l1.val;
            secVal = l2.val;
            
            total  = firstVal + secVal + carry;
            
            carry = total/10;
            total = total%10;
            
            ListNode newNode = new ListNode(total);
            
            dummyNode.next = newNode;
            dummyNode = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!= null){
            total = l1.val + carry;
            carry = total/10;
            total = total%10;
            ListNode newNode = new ListNode(total);
            dummyNode.next = newNode;
            dummyNode= newNode;
            l1 = l1.next;
        }
        while(l2!= null){
            total = l2.val + carry;
            carry = total/10;
            total = total%10;
            ListNode newNode = new ListNode(total);
            dummyNode.next = newNode;
            dummyNode= newNode;
            l2 = l2.next;
        }
        if(carry!= 0){
            ListNode newNode = new ListNode(1);
            dummyNode.next = newNode;
        }
        return head.next;
    }
}