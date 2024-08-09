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
    public int[][] spiralMatrix(int m,int n,ListNode head){
        int[][] ans = new int[m][n];
        ListNode curr = head;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
        int dir = 0;
        
        while(top<=down && left<=right && curr != null){
            if(dir == 0){
                for(int i = left;i<=right&&curr != null;i++){
                    ans[top][i] = curr.val;
                    curr = curr.next;
                }    
                top++;
            }
            else if(dir == 1){
                for(int i = top;i<=down&&curr != null;i++){
                    ans[i][right] = curr.val;
                    curr = curr.next;
                }
                right--;
            }
            else if(dir == 2){
                for(int i = right;i>=left&&curr != null;i--){
                    ans[down][i] = curr.val;
                    curr = curr.next;
                }
                down--;
            }
            else if(dir == 3){
                for(int i = down;i>=top&&curr != null;i--){
                    ans[i][left] = curr.val;
                    curr = curr.next;
                }
                left++;
            }
            
            dir = (dir+1)%4;
        }
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(ans[i][j] == Integer.MAX_VALUE){
                    ans[i][j] = -1;
                }
            }
        }
        return ans;
    }
}