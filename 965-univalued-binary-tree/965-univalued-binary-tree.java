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
    public boolean isUnivalTree(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        return isPossible(root,root.val);
    }
    public boolean isPossible(TreeNode root,int compVal){
        if(root == null){
            return true;
        }
        if(root.val != compVal){
            return false;
        }
        
         boolean left = isPossible(root.left,compVal);
         boolean right = isPossible(root.right,compVal);
        
        return (left && right);
    }
}