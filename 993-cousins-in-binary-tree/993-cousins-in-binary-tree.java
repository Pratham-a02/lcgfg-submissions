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
    public boolean isCousins(TreeNode root, int x, int y){
        int[] levels = {-1,-1};
        TreeNode[] parents = {null,null};
        
        areCousins(root,x,y,levels,parents,0,null);
        if(levels[0] == levels[1] && parents[0] != parents[1])
            return true;
        return false;
    }
    
    private void areCousins(TreeNode root,int x,int y,int[] levels,TreeNode[] parents,int currLevel,TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            parents[0] = parent;
            levels[0] = currLevel;
        }
        if(root.val == y){
            parents[1] = parent;
            levels[1] = currLevel;
        }
        areCousins(root.left,x,y,levels,parents,currLevel+1,root);
        areCousins(root.right,x,y,levels,parents,currLevel+1,root);
        
        return;
    }
}