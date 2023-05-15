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
    long sum = 0;
    long max = 0;
    
    public int maxProduct(TreeNode root){
        if(root == null)return 0;
        sum = 0;
        sum = totalSum(root);
        max = 0;
        totalSum(root);
        return (int)(max%1000000007);
    }
    
    public long totalSum(TreeNode root){
        if(root == null){
            return 0;
        }
        
        long ls = totalSum(root.left);
        long rs = totalSum(root.right);
        
        long subTreeSum = ls + rs + root.val;
        long remainingSum = sum - subTreeSum;
        
        max = Math.max(max,subTreeSum*remainingSum);
        
        
        return subTreeSum;
    }
}