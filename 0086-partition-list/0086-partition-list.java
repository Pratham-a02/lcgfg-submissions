/*** Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution{
    public ListNode partition(ListNode head, int x){
        ListNode smaller = new ListNode(-1);
        ListNode larger = new ListNode(-1);
        
        ListNode ps = smaller;
        ListNode pl = larger;
        
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val < x){
                ps.next = curr;
                ps = ps.next;
                curr = curr.next;
            }
            else{
                pl.next = curr;
                pl = pl.next;
                curr = curr.next;
            }
        }
        
        pl.next = null;
        ps.next = larger.next;
        
        return smaller.next;
    }
}