/*** public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(){}
 *     ListNode(int val){ this.val = val;}
 *     ListNode(int val,ListNode next){this.val = val; this.next = next;}
 * }*/
class Solution{
    public int pairSum(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode nHead = reverse(temp);
        int max = Integer.MIN_VALUE;
        ListNode ptr1 = head;
        ListNode ptr2 = nHead;
        while(ptr1 != null && ptr2 != null){
            max = Math.max(max,ptr1.val+ptr2.val);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return max;
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}