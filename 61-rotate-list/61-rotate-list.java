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
    public int findLength(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!= null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int n = findLength(head);
        if(k == 0 || k%n == 0) return head;
        k = k%n;
        ListNode curr = head;
        for(int i = 0;i<n-k-1;i++){
            curr = curr.next;
        }
        ListNode temp = curr.next;
        ListNode p1 = head;
        while(p1.next!= null){
            p1 = p1.next;
        }
        p1.next = head;
        curr.next = null;
        return temp;
    }
}