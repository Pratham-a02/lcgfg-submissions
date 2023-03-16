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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int counter = 1;
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(counter!= left){
            curr = curr.next;
            pre = pre.next;
            counter++;
        }
        
        pre.next = null;
        ListNode temp = curr;
        while(counter!= right){
            temp = temp.next;
            counter++;
        }
        ListNode ntemp = temp.next;
        temp.next = null;
        ListNode nHead = reverseLL(curr);
        pre.next = nHead;
        ListNode ptr = head;
        while(ptr.next!= null){
            ptr = ptr.next;
        }
        ptr.next = ntemp;
        return dummy.next;
    }
    
    public ListNode reverseLL(ListNode head){
        ListNode pre = null;
        ListNode ptr = head;
        while(ptr!= null){
            ListNode temp = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = temp;
        }
        return pre;
    }
}