/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
            
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!= null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
//     if(head==null){
//             return false;
//         }
        
//         ListNode slowPtr = head;
        
//         ListNode fastPtr = head;
        
//         while(fastPtr.next != null && fastPtr.next.next != null){
            
//             slowPtr = slowPtr.next;
//             fastPtr = fastPtr.next.next;
            
//             if(slowPtr == fastPtr){
//                 return true;
//             }
//         }
        
//         return false;
}