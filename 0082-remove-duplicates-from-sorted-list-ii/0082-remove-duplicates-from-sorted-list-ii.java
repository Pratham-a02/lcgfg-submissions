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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(-101);
        ListNode curr = head.next;
        dummy.next = head;
        ListNode itr = dummy;
        
        while(curr != null){
            boolean flag = false;
            while(curr!= null && itr.next.val == curr.val){
                flag = true;
                curr = curr.next;
            }
            
            if(flag){
                itr.next = curr;
            }
            else{
                itr = itr.next;
            }
            
            if(curr!= null){
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}