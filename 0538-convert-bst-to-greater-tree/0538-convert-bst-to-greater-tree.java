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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        sum = 0;
        greaterTree(root);
        return root;
    }
    public void greaterTree(TreeNode root){
        if(root == null){
            return;
        }
        greaterTree(root.right);
        root.val+= sum;
        sum = root.val;
        greaterTree(root.left);
        
    }
}