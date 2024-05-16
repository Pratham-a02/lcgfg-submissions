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
class Solution {
    public boolean evaluateTree(TreeNode root) {
        return solve(root);
    }
    
    public boolean solve(TreeNode root){
        if(root.left == null && root.right == null){
            return (root.val == 1)?true:false;
        }
        
        boolean ls = solve(root.left);
        boolean rs = solve(root.right);
        
        if(root.val == 2){
            return (ls || rs);
        }
        else{
            return (ls && rs);
        }
    }
}