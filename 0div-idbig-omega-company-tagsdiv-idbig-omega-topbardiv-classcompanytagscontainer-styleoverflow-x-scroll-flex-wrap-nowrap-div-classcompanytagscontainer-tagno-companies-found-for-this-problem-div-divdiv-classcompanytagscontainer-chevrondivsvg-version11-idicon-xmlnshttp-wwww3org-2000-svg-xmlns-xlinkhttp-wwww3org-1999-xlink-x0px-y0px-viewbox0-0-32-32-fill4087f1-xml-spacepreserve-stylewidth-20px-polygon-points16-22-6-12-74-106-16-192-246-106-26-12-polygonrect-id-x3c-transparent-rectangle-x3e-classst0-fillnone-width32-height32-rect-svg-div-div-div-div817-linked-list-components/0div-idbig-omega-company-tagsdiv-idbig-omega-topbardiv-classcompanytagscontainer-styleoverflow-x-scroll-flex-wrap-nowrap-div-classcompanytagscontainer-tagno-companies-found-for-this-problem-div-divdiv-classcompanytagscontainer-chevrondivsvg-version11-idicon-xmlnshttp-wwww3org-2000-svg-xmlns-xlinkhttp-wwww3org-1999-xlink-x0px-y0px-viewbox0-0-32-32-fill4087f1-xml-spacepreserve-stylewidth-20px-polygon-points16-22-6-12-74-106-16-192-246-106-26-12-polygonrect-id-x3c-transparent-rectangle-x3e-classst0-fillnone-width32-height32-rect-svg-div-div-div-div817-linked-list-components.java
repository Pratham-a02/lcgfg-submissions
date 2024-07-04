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
    public int numComponents(ListNode head, int[] nums) {    
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        
        if(head == null) {
            return 0;
        }
        
        if(head.next == null){
            if(!hs.contains(head.val)){
                return 0;
            }
            else{
                return 1;
            }
        }
        ListNode curr = head;
        int ans = 0;
        boolean flag = false;
        while(curr != null){
            if(hs.contains(curr.val)){
                if(flag == false){
                    flag = true;
                    ans++;
                }
            }
            else{
                flag = false;
            }
            curr = curr.next;
        }
        return ans;
    }
}