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
    public boolean isValidBST(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }
        return solve(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean solve(TreeNode root,long leftlimit,long rightlimit){
        if(root == null){
            return true;
        }
        
        if(root.val <= leftlimit || root.val >= rightlimit){
            return false;
        }
        
        return solve(root.left,leftlimit,root.val) && solve(root.right,root.val,rightlimit);
    }
}