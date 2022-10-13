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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        sumFromNtoN(root);
        return max;
    }
    
    public int sumFromNtoN(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = sumFromNtoN(root.left);
        int right = sumFromNtoN(root.right);
        
        int left_d = Math.max(left,0);
        int right_d = Math.max(right,0);
        
        int comparator = left_d + right_d + root.val;
        
        if(comparator>max){
            max = comparator;
        }
        return Math.max(left_d,right_d) + root.val;
    }
}