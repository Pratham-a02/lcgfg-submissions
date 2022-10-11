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
    public int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = 1+ findHeight(root.left);
        int right = 1 + findHeight(root.right);
        
        return Math.max(left,right);
    }
    
    public int findBottomLeftValue(TreeNode root) {
        int height = findHeight(root);
        int[] ans = new int[1];
        
        findAns(root,1,height,ans);
        return ans[0];
    }
    
    public void findAns(TreeNode root,int level,int height,int[] ans){
        if(root == null){
            return;
        }
        if(level == height && root!= null){
            ans[0] = root.val;
        }
        
        findAns(root.right,level+1,height,ans);
        findAns(root.left,level+1,height,ans);
        return;
    }
}