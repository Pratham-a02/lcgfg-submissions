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
    
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode nl1 = reverse(l1);
        ListNode nl2 = reverse(l2);
        
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        ListNode curr1 = nl1;
        ListNode curr2 = nl2;
        int carry = 0;
        
        while(curr1 != null && curr2 != null){
            int sum = curr1.val + curr2.val + carry;
            
            int val = sum%10;
            carry = sum/10;
            
            ListNode nNode = new ListNode(val);
            ptr.next = nNode;
            curr1 = curr1.next;
            curr2 = curr2.next;
            ptr = ptr.next;
        }
        
        while(curr1 != null){
            int sum = curr1.val + carry;
            
            int val = sum%10;
            carry = sum/10;
            
            ListNode nNode = new ListNode(val);
            ptr.next = nNode;
            curr1 = curr1.next;
            ptr = ptr.next;
        }
        
        while(curr2 != null){
            int sum = curr2.val + carry;
            
            int val = sum%10;
            carry = sum/10;
            
            ListNode nNode = new ListNode(val);
            ptr.next = nNode;
            curr2 = curr2.next;
            ptr = ptr.next;
        }
        
        if(carry != 0){
            ListNode nNode = new ListNode(carry);
            ptr.next = nNode;
            ptr = ptr.next;
        }
        
        ListNode nHead = dummy.next;
        nHead = reverse(nHead);
        return nHead;
    }
}