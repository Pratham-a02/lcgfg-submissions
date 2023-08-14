/** public class TreeNode{
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(){}
 *     TreeNode(int val){ this.val = val;}
 *     TreeNode(int val,TreeNode left,TreeNode right){
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;*}*}*/
class Solution{
    public TreeNode trimBST(TreeNode root,int low,int high){
        return solve(root,low,high);
    }
    
    public TreeNode solve(TreeNode root,int low,int high){
        if(root == null) return null;
        
        TreeNode leftNode = trimBST(root.left,low,high);
        if(leftNode != root.left){
            root.left = leftNode;
        }
        TreeNode rightNode = trimBST(root.right,low,high);
        
        if(rightNode != root.right){
            root.right =  rightNode;
        }
        
        if(root.val < low || root.val > high){
            return (root.left != null)?root.left : root.right;
        }
        return root;
    }
}