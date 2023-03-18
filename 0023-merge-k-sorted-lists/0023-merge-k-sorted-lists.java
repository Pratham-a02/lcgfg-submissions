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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return mergeK(lists,0,lists.length-1);
    }
    
    public ListNode mergeK(ListNode[] lists,int si,int ei){
        if(si == ei){
            return lists[si];
        }
        
        int mid = (si + ei)/2;
        
        ListNode l1 = mergeK(lists,si,mid);
        ListNode l2 = mergeK(lists,mid+1,ei);
        
        return mergeTwo(l1,l2);
    }
    
    public ListNode mergeTwo(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }
            else if(l2.val < l1.val){
                temp.next = l2;
                l2 = l2.next;
            }
            else if(l1.val == l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 == null)?l2:l1;
        
        return dummy.next;
    }
}