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
        ListNode pre = head;
	    ListNode curr = head;
	    
	    while(curr != null){
	        if(pre.val == curr.val){
	            curr = curr.next;
	        }
	        else{
	            pre.next = curr;
	            pre = curr;
	        }
	    }
	    pre.next = curr;
	    return head;
    }
}