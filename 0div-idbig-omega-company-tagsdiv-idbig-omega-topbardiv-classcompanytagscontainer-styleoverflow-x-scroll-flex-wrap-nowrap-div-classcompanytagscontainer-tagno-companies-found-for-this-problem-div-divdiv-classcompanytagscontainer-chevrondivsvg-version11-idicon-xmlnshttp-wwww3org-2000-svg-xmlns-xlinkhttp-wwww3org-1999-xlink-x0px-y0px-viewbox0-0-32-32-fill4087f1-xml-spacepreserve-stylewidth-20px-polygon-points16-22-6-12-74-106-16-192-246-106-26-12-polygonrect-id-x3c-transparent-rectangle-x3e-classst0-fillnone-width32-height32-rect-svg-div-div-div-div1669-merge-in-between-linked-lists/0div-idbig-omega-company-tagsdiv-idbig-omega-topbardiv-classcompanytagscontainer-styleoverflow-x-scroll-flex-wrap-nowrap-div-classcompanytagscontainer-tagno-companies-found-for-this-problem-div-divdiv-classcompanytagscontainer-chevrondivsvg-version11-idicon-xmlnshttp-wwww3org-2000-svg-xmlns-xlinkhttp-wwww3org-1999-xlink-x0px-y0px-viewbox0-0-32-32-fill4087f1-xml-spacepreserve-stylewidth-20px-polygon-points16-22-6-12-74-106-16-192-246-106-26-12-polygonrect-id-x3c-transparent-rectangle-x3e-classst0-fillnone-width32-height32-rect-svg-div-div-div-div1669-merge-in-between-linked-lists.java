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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;
        
        ListNode curr1 = list1;
        int ptr = 0;
        while(ptr != a-1){
            curr1 = curr1.next;
            ptr++;
        }
        
        ListNode curr2 = curr1;
        while(ptr != b){
            curr2 = curr2.next;
            ptr++;
        }
        
        ListNode temp = curr2.next;
        curr2.next = null;
        curr1.next = list2;
        curr1 = dummy;
        
        while(curr1.next != null){
            curr1 = curr1.next;
        }
        curr1.next = temp;
        
        return dummy.next;
    }
}