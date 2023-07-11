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
        int counter = 1;
        
        while(counter != left){
            counter++;
            pre = pre.next;
            curr = curr.next;
        }
        
        pre.next = null;
        ListNode temp = curr;
        while(counter != right){
            counter++;
            temp = temp.next;
        }
        
        ListNode nTemp = temp.next;
        temp.next = null;
        ListNode nHead = reverse(curr);
        
        pre.next = nHead;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = nTemp;
        
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