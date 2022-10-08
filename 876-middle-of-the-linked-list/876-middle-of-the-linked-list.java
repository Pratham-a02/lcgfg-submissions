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
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next!= null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
        // ListNode curr = head;
        // int count = 0;
        // while(curr != null){
        //     curr = curr.next;
        //     count++;
        // }
        // ListNode pointer = head;
        // for(int i = 0;i<count/2;i++){
        //         pointer = pointer.next;
        //     }
        // return pointer;
        // }
    
}