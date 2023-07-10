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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        int len = 0;
        ListNode curr = head;
        
        while(curr != null){
            curr = curr.next;
            len++;
        }
        
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        
        ListNode pe = even;
        ListNode po = odd;
        
        curr = head;
        
        for(int i = 0;i<len;i++){
            if(i%2 == 0){
                pe.next = curr;
                pe = pe.next;
                curr = curr.next;
            }
            else{
                po.next = curr;
                po = po.next;
                curr = curr.next;
            }
        }
        if(len%2 == 0){
            pe.next = null;
            pe.next = odd.next;
        }
        else{
            po.next = null;
            pe.next = odd.next;
        }
        
        return even.next;
    }
}