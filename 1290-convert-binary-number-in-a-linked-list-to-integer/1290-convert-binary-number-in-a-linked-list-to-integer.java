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
    public int getDecimalValue(ListNode head) {
        StringBuilder s = new StringBuilder();
        while(head!= null){
            s.append(head.val);
            head = head.next;                         // appending int values of ListNode into String
        }
        return Integer.parseInt(s.toString(), 2);     // here the radix value is 2 
    }
}