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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null){
            return new int[]{-1,-1};
        }
        int length = 0;
        ListNode curr = head;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        if(length<3){
            return new int[]{-1,-1};
        }
        
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;
        
        List<Integer> al = new ArrayList<>();
        curr = head.next;
        ListNode prev = head;
        int idx = 1;
        
        while(curr.next != null){
            if(curr.val > prev.val && curr.val > curr.next.val){
                al.add(idx);
            }
            if(curr.val < prev.val && curr.val < curr.next.val){
                al.add(idx);
            }
            idx++;
            prev = curr;
            curr = curr.next;
        }
        if(al.size() <2){
            return new int[]{-1,-1};
        }
        for(int i = 1;i<al.size();i++){
            minDist = Math.min(minDist,al.get(i) - al.get(i-1));
        }
        maxDist = Math.max(maxDist,al.get(al.size()-1) - al.get(0));
        
        return new int[]{minDist,maxDist};
    }
}