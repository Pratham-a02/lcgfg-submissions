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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!= null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!= null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        if(head.next == null)
            return true;
        ListNode midNode = middleNode(head);
        ListNode tempNode = midNode.next;
        midNode.next = null;
        ListNode tempList = reverseList(tempNode);
        return compare(head,tempList);
    }
    public boolean compare(ListNode l1, ListNode l2){
        // if(l1 == null || l2 == null)
        //     return false;
        while(l1 != null && l2 != null){
            if(l1.val != l2.val){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}