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
        long min;
        long max;
    }
    long maxW = 0L;
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Long,Pair> hm = new HashMap<>();
        maxW = 0;
        helper(root,1L,1L,hm);
        return (int)maxW;
    }
    public void helper(TreeNode root,long level,long idx,HashMap<Long,Pair> hm){
        if(root == null){
            return;
        }
        helper(root.left,level+1,2*idx,hm);
        helper(root.right,level+1,2*idx+1,hm);
        
        Pair p = null;
        if(hm.containsKey(level)){
            p = hm.get(level);
            p.min = Math.min(p.min,idx);
            p.max = Math.max(p.max,idx);
        }
        else{
            p = new Pair();
            p.min = idx;
            p.max = idx;
            hm.put(level,p);
        }
        long width = p.max - p.min + 1;
        if(width>maxW){
            maxW = width;
        }
        return;
    }
}