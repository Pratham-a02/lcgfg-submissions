/*public class ListNode{
 *     int val;
 *     ListNode next;
 *     ListNode(){}
 *     ListNode(int val){ this.val = val;}
 *     ListNode(int val,ListNode next){this.val = val;this.next = next;}}*/

class Solution{
    public ListNode removeZeroSumSublists(ListNode head){
        HashMap<Integer,ListNode> hm = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        hm.put(0,dummy);
        int ps = 0;
        while(head != null){
            ps += head.val;
            
            if(hm.containsKey(ps)){
                ListNode p = hm.get(ps);
                ListNode start = p;
                int currps = ps;
                while(start != head){
                    start = start.next;
                    currps += start.val;
                    if(start != head){
                        hm.remove(currps);
                    }
                }
                p.next = start.next;
            }
            else{
                hm.put(ps,head);
            }
            head = head.next;
        }
        return dummy.next;
    }
}