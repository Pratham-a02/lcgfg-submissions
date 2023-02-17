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
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }
    
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        
        dfs(root.left);
        if(prev!=null){
            min = Math.min(min,root.val-prev.val);
        }
        prev = root;
        dfs(root.right);
    }
}