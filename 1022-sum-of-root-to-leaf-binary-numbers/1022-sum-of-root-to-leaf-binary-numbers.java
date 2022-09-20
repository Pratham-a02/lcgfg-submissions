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
    
    public int sumRootToLeaf(TreeNode root){
        int[] ans = new int[1];
        ans[0] = 0;
        totalSum(root,ans,"");
        return ans[0];
    }
    
    private void totalSum(TreeNode root,int[] ans,String curr){
        if(root.left == null && root.right == null){
            curr += root.val;
            ans[0] += Integer.parseInt(curr,2);
            return;
        }
        curr += root.val;
        if(root.left != null){
        totalSum(root.left,ans,curr);}
        if(root.right != null){
        totalSum(root.right,ans,curr);}
        
        return;
        
        
        
    }
}