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
    public ListNode sortList(ListNode head) {
        return doSort(head);
    }
    public ListNode doSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode l1 = head;
        
        ListNode left = doSort(l1);
        ListNode right = doSort(l2);
        
        return mergeTwoLists(left,right);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        
        if(l2 == null){
            return l1;
        }
        
        ListNode dummyNode = new ListNode(-101);
        ListNode head = dummyNode;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ListNode newNode = new ListNode(l1.val);
                dummyNode.next = newNode;
                l1 = l1.next;
            }
            else{
                ListNode newNode = new ListNode(l2.val);
                dummyNode.next = newNode;
                l2 = l2.next;
            }
            dummyNode = dummyNode.next;
        }
        
        if(l1 == null){
            dummyNode.next = l2;
        }
        
        if(l2==null){
            dummyNode.next = l1;
        }
        
        return head.next;
    }
}