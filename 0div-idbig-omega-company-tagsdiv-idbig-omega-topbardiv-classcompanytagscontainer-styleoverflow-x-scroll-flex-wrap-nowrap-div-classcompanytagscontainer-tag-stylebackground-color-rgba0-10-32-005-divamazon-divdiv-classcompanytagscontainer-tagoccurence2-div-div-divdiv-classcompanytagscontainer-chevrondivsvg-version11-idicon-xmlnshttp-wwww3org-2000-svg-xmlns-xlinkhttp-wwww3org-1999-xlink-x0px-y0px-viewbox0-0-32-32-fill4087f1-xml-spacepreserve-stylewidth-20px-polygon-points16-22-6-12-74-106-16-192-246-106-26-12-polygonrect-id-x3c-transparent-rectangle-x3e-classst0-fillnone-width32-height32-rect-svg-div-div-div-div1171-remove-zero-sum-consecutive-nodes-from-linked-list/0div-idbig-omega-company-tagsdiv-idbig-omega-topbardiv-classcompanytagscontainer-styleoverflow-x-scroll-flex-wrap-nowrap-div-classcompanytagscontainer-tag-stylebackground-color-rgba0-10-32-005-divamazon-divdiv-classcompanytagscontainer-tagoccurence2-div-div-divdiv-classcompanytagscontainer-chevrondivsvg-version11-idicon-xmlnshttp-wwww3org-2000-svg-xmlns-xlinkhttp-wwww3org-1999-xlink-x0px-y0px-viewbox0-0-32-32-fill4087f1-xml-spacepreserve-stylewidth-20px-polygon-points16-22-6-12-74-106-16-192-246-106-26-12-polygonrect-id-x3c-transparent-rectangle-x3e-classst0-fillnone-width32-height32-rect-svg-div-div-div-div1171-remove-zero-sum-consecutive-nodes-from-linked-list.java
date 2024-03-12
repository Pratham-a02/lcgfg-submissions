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
class Solution{
    public ListNode removeZeroSumSublists(ListNode head){
        HashMap<Integer,ListNode> hm = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int sum = 0;
        for(ListNode p = dummy;p!= null;p = p.next){
            sum += p.val;
            hm.put(sum,p);
        }
        
        sum = 0;
        for(ListNode p = dummy;p!= null;p = p.next){
            sum += p.val;
            p.next = hm.get(sum).next;
        }
        
        return dummy.next;
    }
}