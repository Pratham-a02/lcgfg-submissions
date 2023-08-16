/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution{
    public int longestZigZag(TreeNode root){
        int[] max = new int[1];
        solve(root,0,max,true);
        return max[0];
    }
    
    public void solve(TreeNode root,int steps,int[] max,boolean goLeft){
        if(root == null) return;
        
        max[0] = Math.max(max[0],steps);
        
        if(goLeft == true){
            solve(root.left,steps+1,max,false);
            solve(root.right,1,max,true);
        }
        else{
            solve(root.right,steps+1,max,true);
            solve(root.left,1,max,false);
        }
    }
}