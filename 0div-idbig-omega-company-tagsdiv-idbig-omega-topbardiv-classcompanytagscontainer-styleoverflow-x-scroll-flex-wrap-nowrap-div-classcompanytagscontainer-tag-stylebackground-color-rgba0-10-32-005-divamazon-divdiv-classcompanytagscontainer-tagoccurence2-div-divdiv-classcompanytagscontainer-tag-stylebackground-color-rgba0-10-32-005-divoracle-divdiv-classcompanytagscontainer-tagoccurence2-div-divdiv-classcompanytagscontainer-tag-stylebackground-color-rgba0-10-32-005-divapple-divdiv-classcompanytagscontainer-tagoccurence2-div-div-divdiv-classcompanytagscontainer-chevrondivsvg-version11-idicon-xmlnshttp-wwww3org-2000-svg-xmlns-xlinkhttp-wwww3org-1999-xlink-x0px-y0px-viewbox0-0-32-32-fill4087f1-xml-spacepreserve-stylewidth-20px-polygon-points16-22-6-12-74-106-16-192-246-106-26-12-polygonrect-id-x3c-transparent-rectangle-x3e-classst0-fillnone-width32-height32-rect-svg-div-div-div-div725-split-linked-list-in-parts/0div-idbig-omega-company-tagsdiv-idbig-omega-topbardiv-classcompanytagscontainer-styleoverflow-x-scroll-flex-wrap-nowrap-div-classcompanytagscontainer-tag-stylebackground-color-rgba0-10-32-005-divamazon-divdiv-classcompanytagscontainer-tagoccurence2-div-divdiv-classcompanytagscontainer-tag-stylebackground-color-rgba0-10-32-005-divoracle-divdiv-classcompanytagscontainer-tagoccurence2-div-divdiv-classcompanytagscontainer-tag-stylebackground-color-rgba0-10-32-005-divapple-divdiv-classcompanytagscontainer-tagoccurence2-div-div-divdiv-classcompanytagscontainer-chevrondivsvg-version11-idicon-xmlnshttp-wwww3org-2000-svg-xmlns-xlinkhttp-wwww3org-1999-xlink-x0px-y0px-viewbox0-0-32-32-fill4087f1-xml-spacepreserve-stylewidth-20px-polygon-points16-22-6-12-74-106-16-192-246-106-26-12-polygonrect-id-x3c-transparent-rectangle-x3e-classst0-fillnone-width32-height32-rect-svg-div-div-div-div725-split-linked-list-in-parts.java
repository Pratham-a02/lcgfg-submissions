/*public class ListNode{
 *     int val;
 *     ListNode next;
 *     ListNode(){}
 *     ListNode(int val){this.val = val;}
 *     ListNode(int val,ListNode next){this.val = val;this.next = next;}*}*/
class Solution{
    public int length(ListNode head){
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
    
    public ListNode[] splitListToParts(ListNode head, int k){
        int len = length(head);
        ListNode[] ans = new ListNode[k];
        int idx = 0;
        if(len < k){
            ListNode curr = head;
            while(curr != null){
                ListNode temp = curr.next;
                curr.next = null;
                ans[idx++] = curr;
                curr = temp;
            }
            while(idx < k){
                ans[idx++] = null;
            }
            return ans;
        }
        
        int size = len/k;
        int extra = len%k;
        ListNode curr = head;
        
        while(curr != null){
            ListNode temp = curr;
            for(int i = 0;i<size-1;i++){
                temp = temp.next;
            }
            
            if(extra>0){
                temp = temp.next;
                extra--;
            }
            
            ListNode nHead = temp.next;
            temp.next = null;
            ans[idx++] = curr;
            curr = nHead;
        }
        return ans;
    }
}