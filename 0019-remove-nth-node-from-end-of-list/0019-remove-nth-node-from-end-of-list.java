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
    
    public int length(ListNode head){
        int len = 0;
        ListNode curr = head;
        
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
        
    public ListNode removeNthFromEnd(ListNode head,int n){
        if(head == null){
            return null;
        }
        int len = length(head);
        int x = len - n;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        int counter = 0;
        
        while(counter != x){
            temp = temp.next;
            counter++;
        }
        
        temp.next = temp.next.next;
        
        return dummy.next;
    }
}