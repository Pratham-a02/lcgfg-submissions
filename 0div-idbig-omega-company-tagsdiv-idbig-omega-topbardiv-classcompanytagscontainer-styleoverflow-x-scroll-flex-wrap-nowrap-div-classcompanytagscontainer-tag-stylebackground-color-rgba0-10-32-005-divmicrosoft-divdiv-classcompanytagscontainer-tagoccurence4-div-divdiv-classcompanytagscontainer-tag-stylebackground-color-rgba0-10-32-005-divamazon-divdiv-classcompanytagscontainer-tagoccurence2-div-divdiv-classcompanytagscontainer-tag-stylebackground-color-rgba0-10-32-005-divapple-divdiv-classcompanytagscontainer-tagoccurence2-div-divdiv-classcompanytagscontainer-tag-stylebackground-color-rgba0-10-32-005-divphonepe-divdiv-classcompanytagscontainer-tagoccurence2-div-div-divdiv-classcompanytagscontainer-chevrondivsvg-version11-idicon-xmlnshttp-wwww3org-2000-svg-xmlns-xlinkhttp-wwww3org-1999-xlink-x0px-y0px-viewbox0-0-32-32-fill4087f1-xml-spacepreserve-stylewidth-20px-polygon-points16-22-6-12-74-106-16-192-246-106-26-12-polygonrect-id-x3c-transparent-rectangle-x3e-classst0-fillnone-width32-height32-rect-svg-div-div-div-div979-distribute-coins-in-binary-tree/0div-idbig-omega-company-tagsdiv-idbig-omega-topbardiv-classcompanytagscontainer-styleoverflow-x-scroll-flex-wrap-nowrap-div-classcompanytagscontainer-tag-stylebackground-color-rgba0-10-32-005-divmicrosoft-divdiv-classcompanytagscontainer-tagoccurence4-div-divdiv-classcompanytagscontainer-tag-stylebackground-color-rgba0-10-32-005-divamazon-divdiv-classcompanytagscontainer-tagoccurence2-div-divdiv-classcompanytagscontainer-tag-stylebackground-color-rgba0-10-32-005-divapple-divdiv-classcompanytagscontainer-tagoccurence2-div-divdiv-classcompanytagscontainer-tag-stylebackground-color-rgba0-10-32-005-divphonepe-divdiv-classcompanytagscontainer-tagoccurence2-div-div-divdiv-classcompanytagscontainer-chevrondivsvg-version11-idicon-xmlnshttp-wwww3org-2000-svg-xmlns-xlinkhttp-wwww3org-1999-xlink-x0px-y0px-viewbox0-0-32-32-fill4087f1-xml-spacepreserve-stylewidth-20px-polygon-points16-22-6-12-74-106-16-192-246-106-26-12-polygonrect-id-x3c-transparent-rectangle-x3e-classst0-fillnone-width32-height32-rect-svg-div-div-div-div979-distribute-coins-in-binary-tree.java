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
class Pair{
    int nnodes;
    int ncoins;
    
    Pair(int nnodes,int ncoins){
        this.nnodes = nnodes;
        this.ncoins = ncoins;
    }
}
class Solution {
    public int distributeCoins(TreeNode root) {
        int[] ans = new int[1];
        solve(root,ans);
        return ans[0];
    }
    
    public Pair solve(TreeNode root,int[] ans){
        if(root == null){
            return new Pair(0,0);
        }
        
        Pair lp = solve(root.left,ans);
        Pair rp = solve(root.right,ans);
        
        Pair retPair = new Pair(1 + lp.nnodes + rp.nnodes,lp.ncoins+rp.ncoins+root.val);
        
        ans[0] += Math.abs(retPair.nnodes - retPair.ncoins);
        
        return retPair;
    }
}