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
    int max;
    public int longestZigZag(TreeNode root){
        max = 0;
        solve(root,true,0);
        return max;
    }
    
    public void solve(TreeNode root,boolean goLeft,int steps){
        if(root == null){
            return;
        }
        
        max = Math.max(max,steps);
        if(goLeft == true){
            solve(root.left,false,steps+1);
            solve(root.right,true,1);
        }
        else{
            solve(root.right,true,steps+1);
            solve(root.left,false,1);
        }
    }
}