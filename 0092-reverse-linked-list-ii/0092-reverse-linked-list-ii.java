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
    public ListNode reverseBetween(ListNode head,int left,int right){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode curr = head;
        int count = 1;
        
        while(count != left){
            pre = pre.next;
            curr = curr.next;
            count++;
        }
        
        ListNode temp1 = curr;
        pre.next = null;
        
        while(count != right){
            count++;
            curr = curr.next;
        }
        
        ListNode temp2 = curr.next;
        curr.next = null;
        
        ListNode nTemp = reverse(temp1);
        pre.next = nTemp;
        
        curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = temp2;
        return dummy.next;
        
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