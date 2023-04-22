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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int ans = findHeight(root);
        
        if(ans != -1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int ls = findHeight(root.left);
        if(ls == -1){
            return -1;
        }
        int rs = findHeight(root.right);
        if(rs == -1){
            return -1;
        }
        
        if(Math.abs(ls-rs) > 1){
            return -1;
        }
        
        return 1 + Math.max(ls,rs);
    }
}