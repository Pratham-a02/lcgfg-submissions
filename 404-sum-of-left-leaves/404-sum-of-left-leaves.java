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
        if(root.left == null && root.right == null){
            return 0;
        }
        int[] ans = new int[1];
        ans[0] = 0;
        totalSum(root,ans,true);
        return ans[0];
    }
    private void totalSum(TreeNode root,int[] ans,boolean rol){
        if(root.left == null && root.right == null && rol == true){
            ans[0] += root.val;
            return;
        }
        if(root.left!= null){
           totalSum(root.left,ans,true);
        }
        if(root.right != null){
           totalSum(root.right,ans,false);        
        }
        return;
    }
}