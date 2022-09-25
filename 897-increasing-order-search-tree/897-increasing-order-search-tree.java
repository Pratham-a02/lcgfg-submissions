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
    public TreeNode increasingBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return root;
        }
        List<Integer> al = new ArrayList<>();
        giveInorder(root,al);
        
        TreeNode dummy = new TreeNode(-1);
        TreeNode newRoot = dummy;
        for(Integer i:al){
            dummy.right = new TreeNode(i);
            dummy = dummy.right;
        }
        return newRoot.right;
    }
    
    private void giveInorder(TreeNode root,List<Integer> al){
        if(root == null){
            return;
        }
        // if(root.left == null && root.right == null){
        //     return;
        // }
        
        giveInorder(root.left,al);
        al.add(root.val);
        giveInorder(root.right,al);
        
        return;
    }
}