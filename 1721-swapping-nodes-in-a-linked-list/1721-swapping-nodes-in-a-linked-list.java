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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        
        for(int i = 0;i<k-1;i++){
            slow = slow.next;
        }
        ListNode temp = slow;
        ListNode s2 = head;
        while(temp.next!= null){
            temp = temp.next;
            s2 = s2.next;
        }
        int val = slow.val;
        slow.val = s2.val;
        s2.val = val;
        
        return head;
    }
}