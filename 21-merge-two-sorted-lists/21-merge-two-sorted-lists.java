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
    static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(-101);
        ListNode curr = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                ListNode newNode = new ListNode(l1.val);
                curr.next = newNode;
                curr = newNode;
                l1 = l1.next;
            }
            else{
                ListNode newNode = new ListNode(l2.val);
                curr.next = newNode;
                curr = newNode;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            ListNode newNode = new ListNode(l1.val);
            curr.next = newNode;
            curr = newNode;
            l1 = l1.next;
        }
        while(l2 != null){
            ListNode newNode = new ListNode(l2.val);
            curr.next = newNode;
            curr = newNode;
            l2 = l2.next;
        }
        return dummy.next;
    }
}