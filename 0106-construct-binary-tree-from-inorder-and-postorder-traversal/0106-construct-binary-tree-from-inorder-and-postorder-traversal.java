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
    public TreeNode buildTree(int[] inorder, int[] postorder){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return construct(postorder.length-1,0,0,inorder.length-1,postorder,hm);
    }
    public TreeNode construct(int post_hi,int post_lo,int in_lo,int in_hi,int[] postorder,HashMap<Integer,Integer> hm){
        
        if(post_hi<post_lo || in_lo>in_hi){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[post_hi]);
        int boundary = hm.get(postorder[post_hi]);
        int lhs = in_hi-boundary;
        
        root.left = construct(post_hi-lhs-1,post_lo,in_lo,boundary-1,postorder,hm);
        root.right = construct(post_hi-1,post_hi-lhs,boundary+1,in_hi,postorder,hm);
        
        return root;
    }
}