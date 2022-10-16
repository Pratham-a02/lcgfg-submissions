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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<postorder.length;i++){
            hm.put(postorder[i],i);
        }
        return construct(0,preorder.length-1,0,postorder.length-1,hm,preorder);
    }
    public TreeNode construct(int pre_lo,int pre_hi,int post_lo,int post_hi,HashMap<Integer,Integer> hm,int[] preorder){
        if(pre_lo> pre_hi || post_lo>post_hi){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pre_lo]);
        if(pre_lo+1<=pre_hi){
        int boundary = hm.get(preorder[pre_lo+1]);
        int lsh = boundary-post_lo+1;
        
        root.left = construct(pre_lo+1,pre_lo+lsh,post_lo,boundary,hm,preorder);
        root.right = construct(pre_lo+lsh+1,pre_hi,boundary+1,post_hi-1,hm,preorder);
        
        return root;
        }
        return root;
    }
}