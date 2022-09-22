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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return isPossible(root,0,targetSum);
    }
    public boolean isPossible(TreeNode root,int currSum,int targetSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            currSum += root.val;
            if(currSum == targetSum){
                return true;
            }
        }
        currSum += root.val;
        
        boolean left = isPossible(root.left,currSum,targetSum);
        boolean right = isPossible(root.right,currSum,targetSum);
        
        return left||right;
    }
}