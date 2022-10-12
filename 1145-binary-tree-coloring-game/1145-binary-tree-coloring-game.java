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
    int xkaleft;
    int xkaright;
    public int findSize(TreeNode root,int x){
        if(root == null){
            return 0;
        }
        int left = findSize(root.left,x);
        int right = findSize(root.right,x);
        
        if(root.val == x){
            xkaleft = left;
            xkaright = right;
        }
        return left+right+1;
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x){
        int size = findSize(root,x);
        int exceptSide = n - (xkaleft+xkaright+1);
        int max = Math.max(exceptSide,Math.max(xkaleft,xkaright));
        int rest = n - max;
        if(max>rest){
            return true;
        }
        return false;
    }
}