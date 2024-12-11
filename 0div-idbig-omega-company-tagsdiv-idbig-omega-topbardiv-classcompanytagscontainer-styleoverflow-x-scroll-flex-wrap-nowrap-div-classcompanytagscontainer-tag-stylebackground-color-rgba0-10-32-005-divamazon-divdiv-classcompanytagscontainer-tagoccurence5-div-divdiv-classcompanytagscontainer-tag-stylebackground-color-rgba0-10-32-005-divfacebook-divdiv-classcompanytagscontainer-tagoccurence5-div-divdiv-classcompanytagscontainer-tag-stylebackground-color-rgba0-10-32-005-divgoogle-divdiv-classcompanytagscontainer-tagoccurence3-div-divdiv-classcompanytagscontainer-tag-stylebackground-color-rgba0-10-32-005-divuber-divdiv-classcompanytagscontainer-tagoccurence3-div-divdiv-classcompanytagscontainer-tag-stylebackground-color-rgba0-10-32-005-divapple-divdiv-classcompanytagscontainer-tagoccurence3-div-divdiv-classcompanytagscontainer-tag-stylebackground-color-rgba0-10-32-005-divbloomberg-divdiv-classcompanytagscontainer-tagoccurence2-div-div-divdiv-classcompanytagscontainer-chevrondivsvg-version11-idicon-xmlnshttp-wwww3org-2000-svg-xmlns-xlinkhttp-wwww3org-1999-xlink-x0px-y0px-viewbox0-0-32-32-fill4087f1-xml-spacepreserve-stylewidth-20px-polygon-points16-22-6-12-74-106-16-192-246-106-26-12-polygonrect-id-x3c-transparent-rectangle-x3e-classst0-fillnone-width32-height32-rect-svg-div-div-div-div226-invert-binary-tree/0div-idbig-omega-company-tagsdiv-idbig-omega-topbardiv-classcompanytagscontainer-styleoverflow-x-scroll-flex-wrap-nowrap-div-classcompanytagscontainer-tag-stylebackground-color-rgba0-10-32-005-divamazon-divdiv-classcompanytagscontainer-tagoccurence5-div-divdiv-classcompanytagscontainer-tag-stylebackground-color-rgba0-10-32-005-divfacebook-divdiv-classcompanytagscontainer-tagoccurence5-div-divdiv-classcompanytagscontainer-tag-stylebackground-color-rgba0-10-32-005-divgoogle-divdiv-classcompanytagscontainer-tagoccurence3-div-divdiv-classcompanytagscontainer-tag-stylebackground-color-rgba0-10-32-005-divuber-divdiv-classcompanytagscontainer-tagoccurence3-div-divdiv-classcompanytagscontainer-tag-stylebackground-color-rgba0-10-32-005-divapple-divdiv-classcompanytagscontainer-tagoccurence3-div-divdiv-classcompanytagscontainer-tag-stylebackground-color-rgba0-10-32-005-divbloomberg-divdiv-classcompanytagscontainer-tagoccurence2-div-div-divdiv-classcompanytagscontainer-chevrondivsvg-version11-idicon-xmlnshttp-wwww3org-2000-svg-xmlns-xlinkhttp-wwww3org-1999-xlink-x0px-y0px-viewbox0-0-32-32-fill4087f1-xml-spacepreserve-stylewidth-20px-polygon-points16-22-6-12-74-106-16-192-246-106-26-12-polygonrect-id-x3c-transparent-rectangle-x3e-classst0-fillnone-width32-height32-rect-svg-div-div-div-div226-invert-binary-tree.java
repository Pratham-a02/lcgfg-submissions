/*public class TreeNode{
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(){}
 *     TreeNode(int val){this.val = val;}
 *     TreeNode(int val,TreeNode left,TreeNode right){
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;}*}*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return solve(root);
    }
    
    public TreeNode solve(TreeNode root){
        if(root == null) return null;
        
        
        
        TreeNode leftTree = solve(root.right);
        TreeNode rightTree = solve(root.left);
        
        root.left = leftTree;
        root.right = rightTree;
        
        return root;
    }
}