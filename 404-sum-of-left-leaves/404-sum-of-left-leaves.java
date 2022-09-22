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
    public int sumOfLeftLeaves(TreeNode root) {
        return totalSum(root,false);
    }
    
    private int totalSum(TreeNode root,boolean rol){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null && rol == true){
            return root.val;
        }
        
        int left = totalSum(root.left,true);
        int right = totalSum(root.right,false);
        
        return left + right;
    }
}