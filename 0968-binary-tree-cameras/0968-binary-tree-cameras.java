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
    int count = 0;
    final int camera = 1;
    final int monitored = 2;
    final int not_monitored = 3;
    
    public int minCameraCover(TreeNode root) {
        
        int val = helper(root);
        if(val == not_monitored){
            count++;
        }
        return count;
    }
    public int helper(TreeNode root){
        if(root == null){
            return monitored;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left == not_monitored || right == not_monitored){
            count++;
            return camera;
        }
        else if(left == camera || right == camera){
            return monitored;
        }
        else{
            return not_monitored;
        }
    }
}