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
        boolean odPos = true;
        ListNode dN1 = new ListNode(-1);
        ListNode dN2 = new ListNode(-1);
        ListNode od = dN1;
        ListNode ed = dN2;
        
        ListNode curr = head;
    
        while(curr != null){
            if(odPos == true){
            ListNode newNode = new ListNode(curr.val);
            od.next = newNode;
            od = newNode;
            odPos = false;
            curr = curr.next;
            }
            else{
            ListNode newNode = new ListNode(curr.val);
            ed.next = newNode;
            ed = newNode;
            odPos = true;
            curr = curr.next;
            }
        }
        od.next = dN2.next;
        return dN1.next;
    }
}