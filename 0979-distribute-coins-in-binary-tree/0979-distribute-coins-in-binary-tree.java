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
    class Pair{
    int nodes;
    int coins;
}

    int moves = 0;
    public int distributeCoins(TreeNode root) {
        minMoves(root);
        return moves;
    }
    public Pair minMoves(TreeNode root){
        if(root == null){
            return new Pair();
        }
        Pair lp = minMoves(root.left);
        Pair rp = minMoves(root.right);
        
        Pair myPair = new Pair();
        myPair.nodes = lp.nodes + rp.nodes + 1;
        myPair.coins = lp.coins + rp.coins + root.val;
        
        moves += Math.abs(myPair.nodes - myPair.coins);
        return myPair;
    }
}