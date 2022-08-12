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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        
        dummy.next = head;
        
        ListNode temp = dummy;
        
        int len = 0;
        
        while(head!= null){
            len++;
            head = head.next;
        }
        
        int x = len - n;
        int counter = 0;
        while(counter != x){
            temp = temp.next;
            counter++;
        }
        temp.next = temp.next.next;
        
        return dummy.next;
    }
}