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
        
        TreeNode nNode = new TreeNode(root.val);
        
        nNode.left = solve(root.right);
        nNode.right = solve(root.left);
        
        return nNode;
    }
}