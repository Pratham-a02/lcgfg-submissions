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
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBst(nums,0,nums.length-1);
    }
    private TreeNode arrayToBst(int[] nums,int i,int j){
        if(i>j){
            return null;
        }
        int mid = (2*i-(i-j))/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBst(nums,i,mid-1);
        root.right = arrayToBst(nums,mid+1,j);
        
        return root;
    }
}