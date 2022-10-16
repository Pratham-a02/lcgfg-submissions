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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return constuct(0,preorder.length-1,0,inorder.length-1,preorder,hm);
    }
    public TreeNode constuct(int pre_lo,int pre_hi,int in_lo,int in_hi,int[] preorder,HashMap<Integer,Integer> hm){
        if(pre_lo>pre_hi || in_lo>in_hi){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_lo]);
        int boundary = hm.get(preorder[pre_lo]);
        int lhs = boundary-in_lo;
        
        root.left = constuct(pre_lo+1,pre_lo+lhs,in_lo,boundary-1,preorder,hm);
        root.right = constuct(pre_lo + lhs+1,pre_hi,boundary+1,in_hi,preorder,hm);
        return root;
    }
}