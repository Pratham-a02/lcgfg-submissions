/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode NodeNext = node.next;
        node.val = NodeNext.val;
        node.next = NodeNext.next;
    }
}